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

/**
 * Funciones de escritura de archivos en memoria
 */
public class IOFiles {

    /**
     * Cambia la configuración establecida cuando es la hora de que cambie a un determinado perfil
     */
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
        String [] estados = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
        Boolean [] focos = newConfig.getFocos();
        for (int i = 0; i <  focos.length; i++) {
            estados[i] = (focos[i]) ? "TRUE" : "FALSE";
        }
        estados[10] = (newConfig.getPuertaPrincipal()) ? "TRUE" :  "FALSE";
        estados[11] = (newConfig.getPuertaPatio()) ? "TRUE" :  "FALSE";
        estados[12] = (newConfig.getGarage()) ? "TRUE" :  "FALSE";
        new DBConnectionWrite().execute("update neun_states set state = (case when device_name = 'led_1' then " + estados[0] + " " +
                "when device_name = 'led_2' then " + estados[1] + " " +
                "when device_name = 'led_3' then " + estados[2] + " " +
                "when device_name = 'led_4' then " + estados[3] + " " +
                "when device_name = 'led_5' then " + estados[4] + " " +
                "when device_name = 'led_6' then " + estados[5] + " " +
                "when device_name = 'led_7' then " + estados[6] + " " +
                "when device_name = 'led_8' then " + estados[7] + " " +
                "when device_name = 'led_9' then " + estados[8] + " " +
                "when device_name = 'led_10' then " + estados[9] + " " +
                "when device_name = 'p_principal' then " + estados[10] + " " +
                "when device_name = 'p_patio' then " + estados[11] + " " +
                "when device_name = 'p_garage' then " + estados[12] + " " +"end)" +
                "where device_name in ('led_1', 'led_2', 'led_3', 'led_4', 'led_5', 'led_6', 'led_7', 'led_8', 'led_9', 'led_10', 'p_principal', 'p_patio', 'garage');");
    }

    /**
     * Escribe en un archivo la nueva configuración actual
     * @param currentConfig Nueva configuración
     * @return true si logró guardar la configuración y false si no se pudo guardar
     */
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


    /**
     * Lee la configuración de un archivo en memoria del dispositivo
     * @return COnfiguración actual de la casa
     */
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

    /**
     * Actualiza la lista de perfiles de configuración
     * @param profiles lista de perfiles de configuración guardados
     * @return Nueva lista de perfiles de configuración guardados
     */
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

    /**
     * Actualiza la lista de horarios programados
     * @param horarios Lista de horarios programados guardados
     * @return Nueva lista de horarios guardados
     */
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

    /**
     * Escribe un nuevo horario en el archivo de horarios programados
     * @param name Nombre del horario
     * @param hour Hora a la que se activa
     * @param minute Minuto en el que se activa
     */
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

    /**
     * Escribe un nombre en la lista de perfiles guardados
     * @param name Nombre del perfil agregado
     */
    public static void writeName(String name) {
        try {
            File filename = new File("data/data/para.neun.smarthome/list.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(filename, true));
            bf.write(name + "/");
            bf.close();
        } catch (Exception e) {
        }
    }

    /**
     * Lee una configuración guaradada desde su archivo y lo deserializa
     * @param name Nombre del perfil
     * @return Perfil que se obtuvo al deserializar
     */
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

    /**
     *  Sobreescribe el archivo que contiene los perfiles de configuración
     * @param profiles
     */
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

    /**
     * Elimina un archivo de configuración cuando el usuario decide borrar un perfil
     * @param name Nombre del perfil a eliminar
     */
    public static void removeFile (String name) {
        try {
            File filename = new File("data/data/para.neun.smarthome/" + name + ".txt");
            filename.delete();
        }catch (Exception e) {

        }
    }
}
