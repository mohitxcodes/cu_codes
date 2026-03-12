document
  .getElementById("studentForm")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission

    const submitBtn = document.getElementById("submitBtn");
    const messageDiv = document.getElementById("message");

    // Disable button and show loading state
    submitBtn.disabled = true;
    submitBtn.textContent = "Submitting...";
    messageDiv.textContent = "";
    messageDiv.className = "message";

    // Collect form data
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;

    console.log("Attempting login for:", email);

    const BACKEND_URL = `http://localhost:8080/login`;

    fetch(BACKEND_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name,
        email: email,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.text().then((text) => {
          console.log(response);
          return text ? JSON.parse(text) : null;
        });
      })
      .then((data) => {
        if (data) {
          console.log("Login Success:", data);
          messageDiv.textContent = "Login successful! Welcome " + data.name;
          messageDiv.className = "message success";
          alert("Login Successful! Welcome " + data.name);
        } else {
          console.log("Login Failed: User not found");
          messageDiv.textContent = "Login failed. Invalid name or email.";
          messageDiv.className = "message error";
          alert("User NOT found in Database!");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        messageDiv.textContent = "An error occurred. Please try again.";
        messageDiv.className = "message error";
      })
      .finally(() => {
        submitBtn.disabled = false;
        submitBtn.textContent = "Login";
      });
  });

// Fetch Students Logic
document.getElementById("fetchBtn").addEventListener("click", function () {
  const fetchBtn = document.getElementById("fetchBtn");
  const listContainer = document.getElementById("studentList");

  fetchBtn.disabled = true;
  fetchBtn.textContent = "Loading...";
  listContainer.innerHTML = ""; // Clear current list

  const FETCH_URL = "http://localhost:8080/getStudents";

  fetch(FETCH_URL)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then((students) => {
      if (students.length === 0) {
        listContainer.innerHTML =
          '<p style="text-align:center; color:#666;">No students found.</p>';
        return;
      }

      students.forEach((student) => {
        const card = document.createElement("div");
        card.className = "student-card";

        // Assuming student object structure. Adjust specific property names if they differ in your backend.
        // e.g. student.name, student.course, etc.
        card.innerHTML = `
                    <h3>${student.name || "No Name"}</h3>
                    <p><strong>Course:</strong> ${student.course || "N/A"}</p>
                    <p><strong>Email:</strong> ${student.email || "N/A"}</p>
                    <p><strong>Section:</strong> ${student.section || "N/A"}</p>
                `;
        listContainer.appendChild(card);
      });
    })
    .catch((error) => {
      console.error("Error fetching students:", error);
      listContainer.innerHTML =
        '<p style="text-align:center; color:red;">Failed to load students.</p>';
    })
    .finally(() => {
      fetchBtn.disabled = false;
      fetchBtn.textContent = "Fetch Students";
    });
});
