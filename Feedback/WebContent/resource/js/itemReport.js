 $(function(){
   var tbody =  $("tbody");
   
   for (var x = 0; x < tbody.length; x++ ) {
    var tr = document.createElement("tr");
    tr.style.color = 'red';
    tr.style.fontWeight = 'bold';
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    
    var trs = $(tbody[x]).children("tr");
    var tds = $(trs).children("td");
    var sum2 = 0;
    var sum3 = 0;
    console.log(tds.length);
    for (var y = 0; y < tds.length; y++) {
        if ((y*3)+1 > tds.length) {
            break;
        }
        sum2 = sum2 + parseFloat(tds[(y*3)+1].innerHTML)
    } 
    
    for (var y = 0; y < tds.length; y++) {
        var max = (y*3)+2;
        if ( max > tds.length) {
            break;
        }
        sum3 = sum3 + parseFloat(tds[max].innerHTML)
    } 
    
    td1.innerHTML = "总分";
    console.log("sum2:"+sum2);
    td2.innerHTML = sum2;
    td3.innerHTML = sum3;
    
    tbody[x].appendChild(tr);
   }
   
   })