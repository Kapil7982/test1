// write js code here corresponding to index.html
// You should add submit event on the form
document.querySelector("#masaiForm").addEventListener("submit",formSubmit)

  var scheduleList = JSON.parse(localStorage.getItem("schedule")) || [];

  function formSubmit()
  {

    event.preventDefault();

    var dataObj = {
      matchNum: masaiForm.matchNum.value,
      teamA: masaiForm.teamA.value,
      teamB: masaiForm.teamB.value,
      date: masaiForm.date.value,
      venue: masaiForm.venue.value,
    };
  
    scheduleList.push(dataObj);
   console.log(scheduleList);

   localStorage.setItem("schedule",JSON.stringify(scheduleList));
  }