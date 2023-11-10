

getAllStudents();

function getAllStudents() {
    const urlParams = new URLSearchParams(window.location.search);
    const room_id = urlParams.get('room_id');
    alert(room_id);
    $.ajax({
      method: "GET",
      url: `http://127.0.0.1:8080/student/getByRoom?roomNumber=${room_id}`,
      success: function(data) {

        $('#StudentTable tbody').empty();
        
        for (let student of data) {
          let id = student.st_id;
          let stuName = student.name;
          let Add1 = student.address_line1;
          let Add2 = student.address_line2;
          let stcity = student.city;
          let nicnum = student.nic;
          let stemail = student.email;
          let stgender = student.gender;
          let  stmobile=student.mobile_no;
          let  stlevel=student.level;


          if(true){

            let newRow = `<tr>
            <td>${id}</td>
            <td>${stuName}</td>
            <td>${Add1}</td>
            <td>${Add2}</td>
            <td>${stcity}</td>
            <td>${nicnum}</td>
            <td>${stemail}</td>
            <td>${stgender}</td>
            <td>${stmobile}</td>
            <td>${stlevel}</td>
            
          </tr>`;
          $('#StudentTable tbody').append(newRow);

          }

    
        }
      }
            ,
      error: function(xhr, status, error) {
        console.log("Error:", error);
      }
    });

  }

  
