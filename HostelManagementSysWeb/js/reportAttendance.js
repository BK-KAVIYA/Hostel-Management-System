getDailyReport();

function getDailyReport() {
    $.ajax({
        method: "GET",
        url: "http://192.168.8.100:8080/attendance/getAllAttendance",
        success: function(data) {
            $('#ReportTable tbody').empty();

            for (let report of data) {
                let attendanceId = report.attendance_id;
                let studentId = report.student_id;
                let roomNumber = report.room_id;
                let dateAndTime = report.date_and_time;
                let status = report.status;

                let newRow = `<tr>
          <td>${attendanceId}</td>
          <td>${studentId}</td>
          <td>${roomNumber}</td>
          <td>${dateAndTime}</td>
          <td>${status}</td>
        </tr>`;

                $('#ReportTable tbody').append(newRow);
            }
        },
        error: function(xhr, status, error) {
            console.log("Error:", error);
        }
    });
}