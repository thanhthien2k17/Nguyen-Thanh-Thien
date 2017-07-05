/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import dto.Acount;
import dto.Employee;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thien
 */
public class ProcessFile {

    public boolean fileWrite(Acount a) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(new File(System.getProperty("user.dir") + "/Acount.txt"), true);
            bw = new BufferedWriter(fw);
            fw.write(a.toString());
            bw.newLine();
            fw.flush();
            return true;
        } catch (IOException e) {

        } finally {
            try {
                bw.close();

                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }



    public List<Acount> fileLoad() {
        List<Acount> list = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(System.getProperty("user.dir") + "/Acount.txt");
            br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] S = br.readLine().split(",");
                Acount e = new Acount(S[0], S[1], S[2]);
                list.add(e);
            }

        } catch (IOException e) {
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;

    }

    public List<Employee> fileLoadEmp() {
        List<Employee> list2 = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(System.getProperty("user.dir") + "/Employee.txt");
            br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] S = s.split(",");
                Employee e = new Employee(S[0], S[1], Float.parseFloat(S[2]));
                list2.add(e);
            }

        } catch (IOException e) {
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list2;

    }

    public boolean fileSave(List<Employee> a) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(new File(System.getProperty("user.dir") + "/Employee.txt"), false);
            bw = new BufferedWriter(fw);
            for (Employee e : a) {
                fw.write(a.toString());
                bw.newLine();
            }
            fw.flush();
            return true;
        } catch (IOException e) {

        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }
}
