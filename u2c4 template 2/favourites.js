// write js code here corresponding to favourites.html

var favourites = JSON.parse(localStorage.getItem("schedule"))||[];
displayData(favourites);


function displayData(data)
{
  document.querySelector("tbody").innerHTML="";

  data.forEach(function(elem){

    var tr= document.createElement("tr");

    var th1 = document.createElement("th");
    th1.innerText = elem.matchNum;

    var th2 = document.createElement("th");
    th2.innerText = elem.teamA;

    var th3 = document.createElement("th");
    th3.innerText = elem.teamB;

    var th4 = document.createElement("th");
    th4.innerText = elem.date;

    var th5 = document.createElement("th");
    th5.innerText = elem.venue;


    var th6 = document.createElement("th");
    th6.innerText = "Delete";
    th6.style.cursor = "pointer";
    th6.style.color = "red"
    th6.addEventListener("click",function(event){

     event.target.parentNode.remove();
    })

    tr.append(th1,th2,th3,th4,th5,th6);
    document.querySelector("tbody").append(tr);
  })

  
}