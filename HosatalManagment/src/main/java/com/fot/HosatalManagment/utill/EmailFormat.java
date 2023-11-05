package com.fot.HosatalManagment.utill;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class EmailFormat {

    public String formatDataForEmail(List<Map<String, Object>> data) {
        StringBuilder htmlData = new StringBuilder();

        htmlData.append("<html><body>");

        // Add CSS styles
        htmlData.append("<style>");
        htmlData.append(".header { text-align: right; padding: 10px; font-size: 14px; }");
        htmlData.append("</style>");


        htmlData.append("<div class='header'>");
        htmlData.append("Hostel Management System<br>");
        htmlData.append("Faculty of Technology<br>");
        htmlData.append("University of Ruhuna<br>");
        htmlData.append("Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        htmlData.append("</div>");

        htmlData.append("<h2>Complain Report</h2>");
        htmlData.append("<table border='1' style='border-collapse: collapse;'>");

        // Add table headers
        htmlData.append("<tr>");
        htmlData.append("<th>ID</th>");
        htmlData.append("<th>Complaint ID</th>");
        htmlData.append("<th>Asset ID</th>");
        htmlData.append("<th>Category</th>");
        htmlData.append("<th>Complaint</th>");
        htmlData.append("<th>Date and Time</th>");
        htmlData.append("<th>Student ID</th>");
        htmlData.append("<th>Student Name</th>");
        htmlData.append("<th>Student Email</th>");
        htmlData.append("<th>Student Mobile</th>");
        htmlData.append("<th>Student Level</th>");
        htmlData.append("<th>Hostel Name</th>");
        htmlData.append("<th>Complaint Status</th>");
        htmlData.append("<th>Room ID</th>");
        htmlData.append("</tr>");

        // Add table rows with data
        for (Map<String, Object> entry : data) {
            htmlData.append("<tr>");
            htmlData.append("<td>").append(entry.get("id")).append("</td>");
            htmlData.append("<td>").append(entry.get("complaint_id")).append("</td>");
            htmlData.append("<td>").append(entry.get("asset_id")).append("</td>");
            htmlData.append("<td>").append(entry.get("category")).append("</td>");
            htmlData.append("<td>").append(entry.get("complaint")).append("</td>");
            htmlData.append("<td>").append(entry.get("date_and_time")).append("</td>");
            htmlData.append("<td>").append(entry.get("student_id")).append("</td>");
            htmlData.append("<td>").append(entry.get("student_name")).append("</td>");
            htmlData.append("<td>").append(entry.get("student_email")).append("</td>");
            htmlData.append("<td>").append(entry.get("student_mobile")).append("</td>");
            htmlData.append("<td>").append(entry.get("student_level")).append("</td>");
            htmlData.append("<td>").append(entry.get("hostel_name")).append("</td>");
            htmlData.append("<td>").append(entry.get("complaint_status")).append("</td>");
            htmlData.append("<td>").append(entry.get("room_id")).append("</td>");
            htmlData.append("</tr>");
        }

        htmlData.append("</table></body></html>");

        return htmlData.toString();
    }

    public String formatDataForTheEmail(List<Map<String, Object>> data) {
        StringBuilder htmlData = new StringBuilder();

        htmlData.append("<html><body>");

        // Add CSS styles
        htmlData.append("<style>");
        htmlData.append(".header { text-align: right; padding: 10px; font-size: 14px; }");
        htmlData.append("</style>");

        htmlData.append("<div class='header'>");
        htmlData.append("Hostel Management System<br>");
        htmlData.append("Faculty of Technology<br>");
        htmlData.append("University of Ruhuna<br>");
        htmlData.append("Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        htmlData.append("</div>");

        htmlData.append("<h2>Complaint Report</h2>");
        htmlData.append("<table border='1' style='border-collapse: collapse;'>");

        // Add table headers
        htmlData.append("<tr>");
        for (String key : data.get(0).keySet()) {
            htmlData.append("<th>").append(key).append("</th>");
        }
        htmlData.append("</tr>");

        // Add table rows with data
        for (Map<String, Object> entry : data) {
            htmlData.append("<tr>");
            for (Object value : entry.values()) {
                htmlData.append("<td>").append(value.toString()).append("</td>");
            }
            htmlData.append("</tr>");
        }

        htmlData.append("</table></body></html>");

        return htmlData.toString();
    }

}
