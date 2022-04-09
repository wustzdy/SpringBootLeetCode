package com.wustzdy.spring.boot.leetcode.standard.algorithm.node;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
//import org.apache.commons.text.StringSubstitutor;

import java.util.*;

public class Test111 {
    public static void main(String[] args) throws JsonProcessingException {
        List<ParamProvider> paramProviders = get();
        tests(paramProviders);

    }

    public static List<ParamProvider> get() {
        String eventPayload = "{\n" +
                "    \"version\":\"4\",\n" +
                "    \"groupKey\":\"{}/{}:{alertname=\\\"up\\\", cluster=\\\"up\\\"}\",\n" +
                "    \"receiver\":\"alertsnitch\",\n" +
                "    \"status\":\"firing\",\n" +
                "    \"alerts\":[\n" +
                "        {\n" +
                "            \"status\":\"firing\",\n" +
                "            \"labels\":{\n" +
                "                \"alertname\":\"up\",\n" +
                "                \"cluster\":\"up\",\n" +
                "                \"group\":\"HK-IDC2-10-5-8-cluster\",\n" +
                "                \"instance\":\"HK-IDC2-10-5-8-196\",\n" +
                "                \"job\":\"HK-IDC2-10-1-75-cluster-ipmi_exporter\"\n" +
                "            },\n" +
                "            \"annotations\":{\n" +
                "                \"summary\":\"'s network is unreachable\"\n" +
                "            },\n" +
                "            \"startsAt\":\"2020-10-09T14:56:37.829237365+08:00\",\n" +
                "            \"endsAt\":\"0001-01-01T00:00:00Z\",\n" +
                "            \"generatorURL\":\"http://10.5.8.196:9090/graph?g0.expr=up+%3E+0\\u0026g0.tab=1\",\n" +
                "            \"fingerprint\":\"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupLabels\":{\n" +
                "        \"alertname\":\"up\",\n" +
                "        \"cluster\":\"up\"\n" +
                "    },\n" +
                "    \"commonLabels\":{\n" +
                "        \"alertname\":\"up\",\n" +
                "        \"cluster\":\"up\"\n" +
                "    },\n" +
                "    \"commonAnnotations\":{\n" +
                "        \"summary\":\"'s network is unreachable\"\n" +
                "    },\n" +
                "    \"externalURL\":\"http://host-10-5-8-196:9093\",\n" +
                "    \"alertTime\":\"2020-10-14T15:02:25.391079409+08:00\"\n" +
                "}";
        List<String> nodes = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode eventPayLoadJson = objectMapper.readTree(eventPayload);

            JsonNode alerts = eventPayLoadJson.get("alerts");
            List<ParamProvider> paramProviders = new ArrayList<>();
            if (alerts.isArray()) {
                ArrayNode alertList = (ArrayNode) alerts;
                for (Iterator<JsonNode> i = alertList.elements(); i.hasNext(); ) {
                    JsonNode n = i.next();
                    JsonNode labels = n.get("labels");

                    String alertName = labels.get("alertname").asText();
                    String cluster = labels.get("cluster").asText();
                    String group = labels.get("group").asText();
                    String instance = labels.get("instance").asText();
                    String job = labels.get("job").asText();

                    nodes.add(alertName);
                    nodes.add(cluster);
                    nodes.add(group);
                    nodes.add(instance);
                    nodes.add(job);

        /*            ParamProvider paramProvider1= new ParamProvider();
                    paramProvider1.setParam(Param.GROUP);
                    paramProvider1.setValue(group);

                    ParamProvider paramProvider2= new ParamProvider();
                    paramProvider2.setParam(Param.INSTANCE);
                    paramProvider2.setValue(instance);

                    ParamProvider paramProvider3= new ParamProvider();
                    paramProvider3.setParam(Param.ALERTNAME);
                    paramProvider3.setValue(alertName);

                    ParamProvider paramProvider4= new ParamProvider();
                    paramProvider4.setParam(Param.CLUSTER);
                    paramProvider4.setValue(cluster);

                    paramProviders.add(paramProvider1);
                    paramProviders.add(paramProvider2);
                    paramProviders.add(paramProvider3);
                    paramProviders.add(paramProvider4);*/

                    paramProviders.add(new ParamProvider(Param.GROUP, group));
                    paramProviders.add(new ParamProvider(Param.INSTANCE, instance));
                    paramProviders.add(new ParamProvider(Param.ALERTNAME, cluster));
                    paramProviders.add(new ParamProvider(Param.CLUSTER, cluster));
                    paramProviders.add(new ParamProvider(Param.NODE, labels.get("node") != null ? labels.get("node").asText() : null));
                }
            }
            System.out.println("nodes: " + objectMapper.writeValueAsString(nodes));

          /*  for (String node : nodes) {
                ParamProvider paramProvider = new ParamProvider();
                paramProvider.setValue(node);
                paramProvider.setParam(Param.NODE);
            }*/
//            System.out.println("--paramProviders--:" + objectMapper.writeValueAsString(paramProviders));
            return paramProviders;
        } catch (Exception e) {
        }
        return null;

    }

    public static void tests(List<ParamProvider> paramProviders) throws JsonProcessingException {
        String title = "slurmctld进程异常";
        String content = "过去5分钟内${group}节点GPU温度持续高于90℃，${instance}请及时与${cluster}运维人员确认是否存在异常";


        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("--paramProviders--:" + objectMapper.writeValueAsString(paramProviders));

        Map<String, String> valuesMap = new HashMap<>();
        for (ParamProvider paramProvider : paramProviders) {
            valuesMap.put(paramProvider.getParam().getValueName(), paramProvider.getValue());
        }
       /* StringSubstitutor sub = new StringSubstitutor(valuesMap);


        //stationLetter
        String stationLetterTitle = sub.replace(title);
        System.out.println("stationLetterTitle:" + stationLetterTitle);
        String stationLetterContent = sub.replace(content);
        System.out.println("stationLetterContent:" + stationLetterContent);*/
    }

}
