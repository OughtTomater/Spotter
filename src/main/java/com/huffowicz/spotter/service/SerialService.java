package com.huffowicz.spotter.service;

import org.springframework.stereotype.Service;
import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class SerialService {
    public String sendFrequencyCommand(String portName, String command) {
        SerialPort comPort = SerialPort.getCommPort(portName);
        comPort.setComPortParameters(38400, 8, 2, 0);
        comPort.setFlowControl(SerialPort.FLOW_CONTROL_RTS_ENABLED | SerialPort.FLOW_CONTROL_DTR_ENABLED);
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 5000, 5000);

        if (!comPort.openPort()) {
            return "Error opening COM port";
        }

        try (OutputStream out = comPort.getOutputStream(); InputStream in = comPort.getInputStream()) {
            out.write(command.getBytes());
            out.flush();

            byte[] readBuffer = new byte[20];
            int numRead = in.read(readBuffer);
            String rawData = new String(readBuffer, 0, numRead).trim();

            if (rawData.startsWith("FA")) {
                rawData = rawData.substring(2).replaceFirst("^0+(?!$)", "");
            }

            String frequencyStr = rawData.length() >= 5 ? rawData.substring(0, 5) : rawData;

            return frequencyStr;
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        } finally {
            comPort.closePort();
        }
    }
}
