package hu.csepel.qrdolgozat;


import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FajlbaIras {

    public static void kiir(String szoveg) throws IOException {
        Date datum = Calendar.getInstance().getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datumFormazott = simpleDateFormat.format(datum);
        String sor = szoveg + ", " + datumFormazott;

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(Environment.getExternalStorageDirectory(), "scannedCodes.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.append(sor);
            bufferedWriter.append(System.lineSeparator());
            bufferedWriter.close();
        }
    }
}
