$(document).ready(function(){
	$(".plus").click(function() {
	 $.ajax({
		    type: "GET",
			url: "products/allproducts",
			dataType: "json",
			async: "false",
			crossDomain: true,
		    contentType: "application/json; charset=utf-8",
		    success: function(data) {
			//alert(data);
				 var html = '';

		            for ( var i in data ) {
		            
		               
		                    html += "   <tr>";
		                    html += "       <td  >"+" </td>";
		                    html += "       <td>"+data[i].productId+"&nbsp;&nbsp; "+"</td>";
		                    html += "       <td>"+data[i].productName+"&nbsp;&nbsp; "+"</td>";
		                    html += "       <td>"+data[i].productPrice+"</td>";
		                    html += "   </tr><br/>";
		                   
		                    
		            	
		            }

		         $('table').append(html);
			},
			error: function(jqXHR, textStatus, errorThrown) {
                      alert(jqXHR+" - "+textStatus+" - "+errorThrown);
            }
	});
    });
});




