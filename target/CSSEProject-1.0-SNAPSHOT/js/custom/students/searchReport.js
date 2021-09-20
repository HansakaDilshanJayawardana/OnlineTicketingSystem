function searchOneStudent(){
	$.ajax({
		type: "POST",
		
		

	
		
		url: "/SchoolManagementSystem/serachReport?action=search", //send to controller
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		
	//success function
		success: function (data) {
			$('#tblViewStudents > tbody').html(''); //clear all data
			$.each(data, function (i, student) { //loop for all rows
				appendStudentTable(student); //below function
			});
		}
	});
}