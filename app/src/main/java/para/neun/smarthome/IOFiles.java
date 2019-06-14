package para.neun.smarthome;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class IOFiles {

    public static void changeConfig() {
        String profileName = "";
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        ArrayList<String> horarios = new ArrayList<>();
        horarios = updateHorarios(horarios);
        for (String aux : horarios) {
            String [] auxiliar = aux.split(" --- ");
            String [] horas = auxiliar[1].split(":");
            if ((hour == Integer.parseInt(horas[0])) && (minute == Integer.parseInt(horas[1]))) {
                profileName = auxiliar[0];
            }
        }
        Home newConfig = readConfig(profileName);
        saveConfig(newConfig);
    }

    public static boolean saveConfig(Home currentConfig) {
        try {
            File filename = new File("data/data/para.neun.smarthome/currentConfig.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(currentConfig);
            writingFile.close();
            return true;

        }catch(Exception e) {
            return false;
        }
    }


    public static Home readConfig(){
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/currentConfig.txt"));
            Home recoveredConfig = (Home) readingFile.readObject();
            readingFile.close();
            return recoveredConfig;

        }catch(Exception e) {
            return null;
        }
    }

    public static ArrayList<String> updateList(ArrayList<String> profiles) {
        String names;
        profiles = new ArrayList<>();
        try {
            File filename = new File("data/data/para.neun.smarthome/list.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(filename));
            names = br.readLine();
            br.close();
        }catch(Exception e) {
            names = "";
        }
        if (names != null) {
            String [] namesArray = names.split("/");
            for (String aux : namesArray) {
                if (!aux.equals("")) {
                    profiles.add(aux);
                }
            }
        }

        return profiles;
    }

    public static ArrayList<String> updateHorarios(ArrayList<String> horarios) {
        String names;
        horarios = new ArrayList<>();
        try {
            File filename = new File("data/data/para.neun.smarthome/horarios.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(filename));
            names = br.readLine();
            br.close();
        }catch (Exception e) {
            names = "";
        }
        if (names != null) {
            String [] nameSplit = names.split("/");
            for (String aux : nameSplit) {
                horarios.add(aux);
            }
        }
        return horarios;
    }

    public static void writeHour(String name, int hour, int minute) {
        try {
            File filename = new File("data/data/para.neun.smarthome/horarios.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            BufferedWriter br = new BufferedWriter(new FileWriter(filename, true));
            br.write(name + " --- " + hour + ":" + minute + "/");
            br.close();
        }catch (Exception e) {

        }
    }

    public static void writeName(String name) {
        try {
            File filename = new File("data/data/para.neun.smarthome/list.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(filename, true));
            bf.write(name + "/");
            bf.close();
        } catch (Exception e) {
        }
    }

    public static Home readConfig(String name){
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/" + name +  ".txt"));
            Home recoveredConfig = (Home) readingFile.readObject();
            readingFile.close();
            return recoveredConfig;

        }catch(Exception e) {
            return null;
        }
    }

    public static void overWriteFile(ArrayList<String> profiles) {
        String toWrite = "";
        for (String aux : profiles) {
            toWrite = toWrite + aux + "/";
        }
        try {

            File filename = new File("data/data/para.neun.smarthome/list.txt");
            filename.delete();
            filename.createNewFile();
            BufferedWriter bf = new BufferedWriter(new FileWriter(filename, false));
            bf.write(toWrite);
            bf.close();
        }catch (Exception e) {
            ///
        }
    }

    public static void removeFile (String name) {
        try {
            File filename = new File("data/data/para.neun.smarthome/" + name + ".txt");
            filename.delete();
        }catch (Exception e) {

        }
    }

    public static void writeLeds(Boolean [] leds){
        try {
            File filename = new File("data/data/para.neun.smarthome/leds.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(leds);
            writingFile.close();

        }catch(Exception e) {
        }
    }

    public static Boolean [] readLeds() {
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/leds.txt"));
            Boolean [] recoveredLeds = (Boolean[]) readingFile.readObject();
            readingFile.close();
            return recoveredLeds;

        }catch(Exception e) {
            return null;
        }
    }

    public static void writePuertaPrincipal(Boolean state) {
        try {
            File filename = new File("data/data/para.neun.smarthome/pprincipal.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(state);
            writingFile.close();

        }catch(Exception e) {
        }
    }

    public static Boolean readPuertaPrincipal() {
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/pprincipal.txt"));
            Boolean state = (Boolean) readingFile.readObject();
            readingFile.close();
            return state;

        }catch(Exception e) {
            return null;
        }
    }

    public static void writeTYH(Float [] tyh) {
        try {
            File filename = new File("data/data/para.neun.smarthome/tyh.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(tyh);
            writingFile.close();

        }catch(Exception e) {
        }
    }

    public static Float [] readTYH() {
        try {
            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/tyh.txt"));
            Float [] tyh = {0.0f, 0.0f, 0.0f, 0.0f};
            Float [] readValue = (Float[]) readingFile.readObject();
            readingFile.close();
            if (readValue == null) {
                return tyh;
            }
            return tyh;
        }catch(Exception e) {
            Float [] tyh = {0.0f, 0.0f, 0.0f, 0.0f};
            return tyh;
        }
    }

}
