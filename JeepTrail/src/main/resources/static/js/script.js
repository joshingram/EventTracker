window.addEventListener('load', function(){
	console.log('script.js is loaded');
	
	init();
});

function init(){
	//TODO setup event listeners
	//TODO load initial data
	loadTrailList();
	
	document.createTrail.submit.addEventListener('click', function(e){
  e.preventDefault();
  
  let trail = {
	  name: createTrail.name.value,
	  length: createTrail.length.value,
	  dateCompleted: createTrail.dateCompleted.value,
	  imageUrl: createTrail.imageUrl.value,
	  highestElevation: createTrail.highestElevation.value,
	  notes: createTrail.notes.value
	  };
	  
	  addTrail(trail);
	  })
}

function loadTrailList(){
	//TODO XHR to get the list
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/trails');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				
				let trailList = xhr.responseText;
				console.log(trailList);  //TESTING 
				let trails = JSON.parse(trailList);
				displayTrailList(trails);
			}
				else if (xhr.status === 404) {
				displayError("Trails not found");
			}
			else {
				displayError('An error occurred: ' + xhr.status);
			}
		}
	};
	xhr.send();
}

function displayTrailList(trails){
	let updateDiv = document.getElementById("updateTrailDiv");
	let tbody = document.getElementById("trailTableBody");
	let trailListDiv = document.getElementById("trailListDiv");
	
	let totalDist = 0;
	for (let trail of trails){
		let distance = parseInt(trail.length);
		totalDist += distance;	
	}
	let totalD = document.createElement('h2');
	totalD.textContent = "Total trail miles: " + totalDist;
	trailListDiv.appendChild(totalD);
	
	
	
	tbody.textContent = "";
	if(trails && Array.isArray(trails) && trails.length > 0){
		for (let trail of trails){
		
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			
			td.textContent = trail.id;
			tr.appendChild(td);
			
			td = document.createElement('td');
			
			td.textContent = trail.name;
			tr.appendChild(td);
			tbody.appendChild(tr);
			
			
			tr.addEventListener('click', function(evt){
				getTrail(trail.id);
			})
		}
	}
	updateDiv.style.display = 'none';
}

function getTrail(trailId){
	//TODO XHR to get the list
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/trails/' + trailId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				
				let trailData = xhr.responseText;
				console.log(trailData);  //TESTING 
				let trail = JSON.parse(trailData);
				displayTrail(trail);
			}
				else if (xhr.status === 404) {
				displayError("Trail not found");
			}
			else {
				displayError('An error occurred: ' + xhr.status);
			}
		}
	};
	xhr.send();
}

function displayTrail(trail){
	let createDiv = document.getElementById("createTrailDiv");
	let updateDiv = document.getElementById("updateTrailDiv");
	let listDiv = document.getElementById('trailListDiv');
	listDiv.style.display = 'none';
	
	let trailDiv = document.getElementById('trailDetailsDiv');
	trailDiv.textContent = '';
	trailDiv.style.display = 'block';
	
	let h2 = document.createElement('h2');
	h2.textContent = "Name: " + trail.name;
	trailDiv.appendChild(h2);
	
	h2 = document.createElement('h2');
	h2.textContent = "Length: " + trail.length;
	trailDiv.appendChild(h2);
	
	h2 = document.createElement('h2');
	h2.textContent = "Date completed: " + trail.dateCompleted;
	trailDiv.appendChild(h2);
	
	h2 = document.createElement('h2');
	h2.textContent = "Highest Elevation: " + trail.highestElevation;
	trailDiv.appendChild(h2);
	
	h2 = document.createElement('h2');
	h2.textContent = "Notes: " + trail.notes;
	trailDiv.appendChild(h2);
	
	if (trail.imageUrl){
		img = document.createElement('img');
		img.src = trail.imageUrl;
		trailDiv.appendChild(img);
		console.log(trail.imageUrl)}
		
	let deleteButton = document.createElement('button')	
	deleteButton.textContent = "Delete this trail";
	trailDiv.appendChild(deleteButton);
	deleteButton.addEventListener('click', function(){
		deleteTrail(trail.id)
		})
	
	createDiv.style.display = 'none';
	updateDiv.style.display = 'block';
	
	updateTrail(trail.id)
	
	let backButton = document.createElement('button');
	backButton.textContent = "Back to List";
	trailDiv.appendChild(backButton);
	backButton.addEventListener('click', function(){
		listDiv.style.display = 'block';
		trailDiv.style.display = 'none';
		createDiv.style.display = 'block';
		updateDiv.style.display = 'none';
	})
	
}

function addTrail(trail)  {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', `api/trails`);  
	
	xhr.setRequestHeader("Content-type", "application/json");	
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let trail = JSON.parse(xhr.responseText);
				displayTrail(trail);
				}else {
					console.error("Failed to create trail");
					console.error(xhr.status + " : " + xhr.responseText);
				}
		}
	}
	
	let trailJson = JSON.stringify(trail);
	xhr.send(trailJson);
 }
 
 function updateTrail(trailId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/api/trails/' + trailId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let trailJson = xhr.responseText;
				console.log(trailJson);  //TESTING 
				let trail = JSON.parse(trailJson);
				
				let trailData = document.getElementById('updateTrailDiv');
				let form = document.createElement('form');
				form.name = 'updateTrailForm';
				trailData.appendChild(form);
				let name = document.createElement('input');
				name.name = 'name';
				name.type = 'text';
				name.value = trail.name;
				form.appendChild(name);
				let length = document.createElement('input');
				length.name = 'length';
				length.type = 'number';
				length.value = trail.length;
				form.appendChild(length);
				let dateCompleted = document.createElement('input');
				dateCompleted.name = 'dateCompleted';
				dateCompleted.type = 'date';
				dateCompleted.value = trail.dateCompleted;
				form.appendChild(dateCompleted);
				let imageUrl = document.createElement('input');
				imageUrl.name = 'imageUrl';
				imageUrl.type = 'text';
				imageUrl.value = trail.imageUrl;
				form.appendChild(imageUrl);
				let highestElevation = document.createElement('input');
				highestElevation.name = 'highestElevation';
				highestElevation.type = 'text';
				highestElevation.value = trail.highestElevation;
				form.appendChild(highestElevation);
				let notes = document.createElement('input');
				notes.name = 'notes';
				notes.type = 'text';
				notes.value = trail.notes;
				form.appendChild(notes);

				let submit = document.createElement('input');
				submit.name = 'submit';
				submit.type = 'submit';
				submit.value = 'Update Trail';
				submit.addEventListener('click', function(e) {
					e.preventDefault();
					let newTrail = {
						id: trailId,
						name: name.value,
						length: length.value,
						dateCompleted: dateCompleted.value,
						imageUrl: imageUrl.value,
						highestElevation: highestElevation.value,
						notes: notes.value,
						
					}
					updateTrailSubmit(newTrail);
				})
				form.appendChild(submit);
			}
		}
	}
	xhr.send();

}

function updateTrailSubmit(trail) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `/api/trails/` + trail.id);

	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let trail = JSON.parse(xhr.responseText);
				let trailData = document.getElementById('trailData');
				TrailData.textContent = '';
				getTrail();
			} else {
				console.error("Failed to update Trail event");
				console.error(xhr.status + " : " + xhr.responseText);
			}
		}
	}
	let trailJson = JSON.stringify(trail);
	xhr.send(trailJson);

}

function deleteTrail(trailId){
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', `/api/trails/` + trailId);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if ( xhr.status === 204) {
				getTrail();
			} else {
				console.error("Failed to delete Trail event");
				console.error(xhr.status + " : " + xhr.responseText);
			}
		}
		}
	xhr.send();

}

