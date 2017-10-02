function loadSubCategory(){
var categoryValue = document.getElementById('category').value;
var xhttp=new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("subCategory").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("POST", "ticketSubCategory?categoryValue="+categoryValue, true);
  xhttp.send();
}
