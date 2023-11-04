// script.js
document.addEventListener("DOMContentLoaded", function () {
    const roomList = document.getElementById('room-buttons-container');

    // Function to fetch room numbers from the Spring Boot API
    function fetchRoomNumbers() {
        fetch('http://127.0.0.1:8080/rooms/all')
            .then(response => response.json())
            .then(data => {
                displayRoomNumbers(data);
            })
            .catch(error => {
                console.error('Error fetching room data:', error);
                roomList.innerHTML = 'An error occurred while fetching room data.';
            });
    }

// Function to display room numbers as buttons on the web page
// Function to categorize and display room numbers as buttons on the web page
function displayRoomNumbers(roomNumbers) {
    const roomCategories = document.getElementById('room-categories-container');
    const categories = {
        "100-125": [],
        "200-225": [],
        "300-325": [],
        "400-425": [],
    };

    // Categorize room numbers
    roomNumbers.forEach(roomNumber => {
        const room_id = roomNumber.room_id;
        if (room_id >= 100 && room_id <= 125) {
            categories["100-125"].push(roomNumber);
        } else if (room_id >= 200 && room_id <= 225) {
            categories["200-225"].push(roomNumber);
        } else if (room_id >= 300 && room_id <= 325) {
            categories["300-325"].push(roomNumber);
        } else if (room_id >= 400 && room_id <= 425) {
            categories["400-425"].push(roomNumber);
        }
    });
    let i=1;
    for (const category in categories) {
        if (categories[category].length > 0) {
            const categoryDiv = document.createElement('div');
            categoryDiv.classList.add('category');
            const categoryTitle = document.createElement('h2');
            categoryTitle.textContent = "Floor "+category.charAt(0);
            categoryDiv.appendChild(categoryTitle);


            categories[category].forEach(roomNumber => {
                const button = document.createElement('button');
                const buttonText = roomNumber.room_id + '/' + roomNumber.student_count;
                button.textContent = buttonText;
                button.addEventListener('click', () => {
                    if (roomNumber.student_count < 4) {
                        const url = `assignRoom.html?room_id=${roomNumber.room_id}`;
                        const popupWindow = window.open(url, '_blank', 'width=1000, height=600');

                        if (popupWindow) {
                            popupWindow.focus();
                        } else {
                            alert("Pop-up window was blocked or is not supported by the browser.");
                        }
                    } else {
                        alert("Room is already full!!");
                    }
                });

                categoryDiv.appendChild(button);
            });
            
            roomCategories.appendChild(categoryDiv);
            
        }
        
    }
}




    
    
    
    

    // Call the function to fetch room numbers
    fetchRoomNumbers();
});


