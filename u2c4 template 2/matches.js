// write js code here corresponding to matches.html

var favourites = JSON.parse(localStorage.getItem("schedule")) || [];
displayData(favourites);

function filter(){
    var short = document.querySelector("filterVenue").value;
    console.log(short);
    var filtervenues = favourites.filter(function(elem){
        return elem.venue ===filtervenues;
    })

    console.log(filtervenues);
    

}


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
    th6.innerText = "Favourite";
    th6.style.cursor = "pointer";
    th6.addEventListener("click",function(){

      favourite(elem);
    })

    tr.append(th1,th2,th3,th4,th5,th6);
    document.querySelector("tbody").append(tr);
  })

  function favourite(elem){
    console.log(elem);
    favourites.push(elem);
    localStorage.setItem("favourites",JSON.stringify(favourite));
  }
}