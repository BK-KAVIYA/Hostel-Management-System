



getAllNotices();

function getAllNotices() {

    $.ajax({
      method: "GET",
      url: `http://192.168.8.100:8080/notices/getAll`,
      success: function(data) {

        $('#NoticeTable tbody').empty();
        
        for (let notice of data) {
          let id = notice.nid;
          let dandt = notice.ndate_time;
          let person = notice.n_person;
          let topic = notice.n_topic;
          let notice_d = notice.notice;
          let level = notice.n_level;



          if(true){

            let newRow = `<tr>
            <td>${id}</td>
            <td>${dandt}</td>
            <td>${person}</td>
            <td>${topic}</td>
            <td>${notice_d}</td>
            <td>${level}</td>
            <td><button type="button" class="" onclick="updateNotice(${id})">Edit</button>
            <button type="button" class="delete-button" onclick="deleteNotice(${id})">Delete</button>
            <br>
            </td>
          </tr>`;
          $('#NoticeTable tbody').append(newRow);

          }

    
        }
      }
            ,
      error: function(xhr, status, error) {
        console.log("Error:", error);
      }
    });

  }

  function updateNotice(nid) {


    
    $.ajax({
      method: "GET",
      url: "http://192.168.8.100:8080/notices/getById/" + nid,
      async: true,
      success: function (data) {
        var nid = data.nid;
        var dateandtime = data.ndate_time;
        var person = data.n_person;
        var topic = data.n_topic;
        var notice = data.notice;
        var level = data.n_level;
  
        var url = "../../pages/subwarden/editNotice.html" +
          "?nid=" + encodeURIComponent(nid) +
          "&dateandtime=" + encodeURIComponent(dateandtime) +
          "&person=" + encodeURIComponent(person) +
          "&topic=" + encodeURIComponent(topic) +
          "&notice=" + encodeURIComponent(notice) +
          "&level=" + encodeURIComponent(level);
  
        window.location.href = url;
      },
      error: function (xhr, status, error) {
        console.log("Error:", error);
      }
    });
  }

  function deleteNotice(nid) {
    if (confirm("Are you sure you want to delete this notice?")) {
      $.ajax({
        method: "DELETE",
        url: "http://127.0.0.1:8080/notices/delete/" + nid,
        async: true,
        success: function (data) {
          alert("Notice deleted successfully");
          location.reload(); // Refresh the page after deletion
        },
        error: function (xhr, status, error) {
          alert("Failed to delete notice. Error: " + error);
        }
      });
    }
  }



function updateNotices() {
    let nid = $('#id').val();
    let ndate_time = $('#datetime').val().trim();
    let n_person = $('#person').val().trim();
    let n_topic = $('#topic').val().trim();
    let noticed = $('#notice').val().trim();
    let n_level = $('#level').val();


    if (n_person === "") {
      swal({
        title: "Required filed missing",
        text: "Please fill in  Notice Person field.",
        className: "custom-button-class",
        icon: "error",
        button: "OK",
      }).then(() => {
        $('#person').focus(); // Focus on the invalid field
      });
      return;
    }
  
  
    if (n_topic === "") {
      swal({
        title: "Required filed missing",
        text: "Please fill in Notice Topic field.",
        className: "custom-button-class",
        icon: "error",
        button: "OK",
      }).then(() => {
        $('#topic').focus(); // Focus on the invalid field
      });
      return;
    }
  
  
    if (noticed === "") {
      swal({
        title: "Required filed missing.",
        text: "Please fill in Noiced field.",
        className: "custom-button-class",
        icon: "error",
        button: "OK",
      }).then(() => {
        $('#notice').focus(); // Focus on the invalid field
      });
      return;
    }
  


    $.ajax({
      method: "PUT",
      contentType: "application/json",
      url: "http://192.168.8.100:8080/notices/update/" + nid,
      async: true,
      data: JSON.stringify({
        ndate_time: ndate_time,
        n_person: n_person,
        n_topic: n_topic,
        notice:noticed,
        n_level: n_level
      }),
      success: function(data) {
        swal({
          title: "Good job!",
          text: "Notice updated successfully!",
          icon: "success",
          button: "ok!",
        }).then((value) => {
          if (value) {
            window.location.href = "View_Notice.html";
          }
        });
      },
      error: function(xhr, status, error) {
        alert("Failed to update booking. Error: " + error);
      }
    });
  }
  
