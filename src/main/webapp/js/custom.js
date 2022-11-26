function makeItCapital() {
	
    var name= document.getElementById("name").innerHTML;
     var n=name.toUpperCase();

    document.getElementById("name").innerHTML=n;
    document.getElementById("name").style.color="#0000ff";
   

}


function callFunction(event) {
	console.log(event.target.id);
}