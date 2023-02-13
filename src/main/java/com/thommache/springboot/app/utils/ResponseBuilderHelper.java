package com.thommache.springboot.app.utils;


import com.thommache.springboot.app.enties.Calificacion;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("responseBuilderHelper")
public class ResponseBuilderHelper {

    public JSONObject buildCalificacionesAlumnoResponse(List<Calificacion> calificacionesModel) {
        JSONArray jsonArray = new JSONArray();

        System.out.println(calificacionesModel + " 11111111111111111111111111111");
      //  Map<String,String> list = new ArrayList<>();
        JSONObject jsonSingleElementr = new JSONObject();
        for(Calificacion calificacionAlumnos :calificacionesModel ) {

            JSONObject jsonSingleElement = new JSONObject();

            jsonSingleElement.put("idAlumno", 1);
            jsonSingleElement.put("calificacion", 9.0);
            jsonSingleElement.put("fecha_registro", "2024/01/12");

            jsonArray.put(jsonSingleElement);
        }
        jsonSingleElementr.put(MensajesDeExito.CALIFICACIONES,jsonArray);
        return jsonSingleElementr;
    }

}
