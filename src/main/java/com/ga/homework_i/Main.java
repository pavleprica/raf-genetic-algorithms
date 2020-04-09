package com.ga.homework_i;

import com.ga.homework_i.model.ConfigConstants;
import com.ga.homework_i.service.GeneticAlgorithm;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import java.io.*;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(1, 1);
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(frame);

        if(result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            JSONTokener jsonTokener = new JSONTokener(bufferedReader);
            JSONObject mainObject = new JSONObject(jsonTokener);

            try {
                ConfigConstants.INSTANCE.setRate(mainObject.getDouble("rate"));
                ConfigConstants.INSTANCE.setPopulationSize(mainObject.getInt("populationSize"));
                ConfigConstants.INSTANCE.setPopulationSizeNew(mainObject.getInt("populationSizeNew"));
                ConfigConstants.INSTANCE.setTournament(mainObject.getInt("tournament"));
                ConfigConstants.INSTANCE.setOutput(mainObject.getString("outputFile"));
                ConfigConstants.INSTANCE.setMaxIteration(mainObject.getInt("maxIteration"));
            } catch (Exception e) {
                ConfigConstants.INSTANCE.setRate(0.2);
                ConfigConstants.INSTANCE.setPopulationSize(50);
                ConfigConstants.INSTANCE.setPopulationSizeNew(50);
                ConfigConstants.INSTANCE.setTournament(3);
                ConfigConstants.INSTANCE.setOutput("resultOutput.txt");
                ConfigConstants.INSTANCE.setMaxIteration(100);
            }

            bufferedReader.close();

            new GeneticAlgorithm();
        }

        System.exit(0);


    }
}
