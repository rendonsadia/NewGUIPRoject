/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HP-VICTUS
 */
public class EmployeeDetails {
    public Employee checkCredentials(String username, String password) {
    String filePath = "src/MyClass/EmployeeDetails.csv";
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        boolean skipHeader = true;

        while ((line = br.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            String[] data = line.split(",");
            if (data.length >= 12) {
                // Assuming: username,password,name,position
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new Employee(data[0], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[11]);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // login failed
}

}
