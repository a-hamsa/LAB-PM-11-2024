package com.example.tugas5;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Data> datas = generateDummyDatas();

    private static ArrayList<Data> generateDummyDatas() {
        ArrayList<Data> datas =new ArrayList<>();
        datas.add(new Data(R.drawable.domino,R.drawable.domino,"Budi Astuti","budi1170","agdggaaghd jhad jajdjbja jbja jab jbad ja"));
        datas.add(new Data(R.drawable.pizza,R.drawable.pizza,"John Broon","broon2711","habhadb bhah ba hba jabjab jadajbjbaddbqb iuq db qdkqk"));
        return datas;
    }
}
