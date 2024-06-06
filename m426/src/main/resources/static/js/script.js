// Event listener for form submission
document.getElementById('coachForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    // POST request to create a new Scrum Coach
    fetch('/api/ScrumCoaches', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, email })
    })
        .then(response => response.json())
        .then(data => {
            alert('Scrum Coach added successfully');
            document.getElementById('coachForm').reset();
            loadCoaches();
        })
        .catch(error => console.error('Error:', error));
});

// Event listener for the refresh button
document.getElementById('refreshButton').addEventListener('click', loadCoaches);

// Function to fetch and display Scrum Coaches
function loadCoaches() {
    fetch('/api/ScrumCoaches')
        .then(response => response.json())
        .then(data => {
            const coachesList = document.getElementById('coachesList');
            coachesList.innerHTML = '';
            data.forEach(coach => {
                const li = document.createElement('li');
                li.className = 'list-group-item';
                li.innerHTML = `${coach.name} (${coach.email}) <span class="delete-btn" data-id="${coach.id}">X</span>`;
                coachesList.appendChild(li);
            });
            attachDeleteEventListeners();
        })
        .catch(error => console.error('Error:', error));
}

// Function to attach event listeners to the delete buttons
function attachDeleteEventListeners() {
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function() {
            const coachId = this.getAttribute('data-id');
            if (confirm('Are you sure you want to delete this entry?')) {
                deleteCoach(coachId);
            }
        });
    });
}

// Function to delete a Scrum Coach
function deleteCoach(id) {
    fetch(`/api/ScrumCoaches/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                alert('Scrum Coach deleted successfully');
                loadCoaches();
            } else {
                alert('Failed to delete Scrum Coach');
            }
        })
        .catch(error => console.error('Error:', error));
}