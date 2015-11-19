package com.ctof.codegen;

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

public class Yaml2Json {
    public static void main(final String[] args) throws Exception {
        Yaml yaml = new Yaml();
        FileReader reader = new FileReader(args[0]);
        Map<String, Object> map = (Map<String, Object>) yaml.load(reader);
        reader.close();

        JSONObject jsonObject = new JSONObject(map);
        FileWriter writer = new FileWriter("/tmp/api.json");
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }
}
