package com.nagarro.training;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dataController {
    ArrayList<dataModel> tshirtList = new ArrayList<dataModel>();
    dataView view = new dataView();
    String[] filePath = {
            "C:\\Users\\shrutijain03\\eclipse-workspace\\Demo\\Puma.csv",  
            "C:\\Users\\shrutijain03\\eclipse-workspace\\Demo\\Nike.csv", 
            "C:\\Users\\shrutijain03\\eclipse-workspace\\Demo\\Adidas.csv"
    };

    public void searchData(String color, String size, String gender) {
        for (String fPath : filePath) {
            Path file = Paths.get(fPath);
            Scanner scn = null;
            try {
                scn = new Scanner(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (scn.hasNext()) {
                String row = scn.nextLine().toUpperCase().toString();
                if (!row.isEmpty()) {
                    StringTokenizer token = new StringTokenizer(row, "|");
                    ArrayList<String> arr = new ArrayList<String>(row.length());
                    while (token.hasMoreTokens()) {
                        arr.add(token.nextToken());
                    }
                    if (arr.get(2).equalsIgnoreCase(color) && arr.get(4).equalsIgnoreCase(size) && arr.get(3).equalsIgnoreCase(gender)) {
                        dataModel data = new dataModel(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), Double.parseDouble(arr.get(5)), Double.parseDouble(arr.get(6)), arr.get(7).charAt(0));
                        tshirtList.add(data);
                    }
                }
            }
        }
    }

    public void manageData(String preference) {
        if (preference.equalsIgnoreCase("price")) {
            Collections.sort(tshirtList, new Comparator<dataModel>() {
                public int compare(dataModel o1, dataModel o2) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            });
        } else if (preference.equalsIgnoreCase("rating")) {
            Collections.sort(tshirtList, new Comparator<dataModel>() {
                public int compare(dataModel o1, dataModel o2) {
                    return Double.compare(o2.getRating(), o1.getRating());
                }
            });
        } else if (preference.equalsIgnoreCase("both")) {
            Collections.sort(tshirtList, new Comparator<dataModel>() {
                public int compare(dataModel o1, dataModel o2) {
                    if (o1.getPrice() == o2.getPrice()) {
                        return Double.compare(o2.getRating(), o1.getRating());
                    } else {
                        return Double.compare(o1.getPrice(), o2.getPrice());
                    }
                }
            });
        } else {
            System.out.println("Wrong Preference");
        }
        view.displayTShirt(tshirtList);
    }
}
