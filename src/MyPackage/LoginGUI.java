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
public class LoginGUI {
   public Employee checkCredentials(String username, String password) {
    String filePath = "src/MyPackage/Book2.csv";
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        boolean skipHeader = true;

        while ((line = br.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            String[] data = line.split(",");
            if (data.length >= 14) {
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new Employee(
                        data[2],  // empNumber
                        data[3],  // lastName
                        data[4],  // firstName
                        data[5],  // bday
                        data[6],  // address
                        data[7],  // phoneNumber
                        data[8],  // sss
                        data[9],  // philHealth
                        data[10], // tin
                        data[11], // pagIbig
                        data[12], // status
                        data[13]  // position
                    );
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
   }
}

