$(function() {
	loadStudentList();
	loadTeacherList();
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'year') {
				if (validateRequired('year')) {
					$("#grade").focus().select();					
				}
			}else if(e.target.id === 'grade'){
				if (validateRequired('grade')) {
					$("#class").focus().select();					
				}
			}else if(e.target.id === 'class'){
				if (validateRequired('class')) {
					validateSubmit(e);					
				}
			}
		}
	});
});

const validateSubmit = (event) => {
	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('year')){
		validateRequired('year');
		err++;
	}
	
	if(!validateRequired('grade')){
		validateRequired('grade');
		err++;
	}
	
	if(!validateRequired('class')){
		validateRequired('class');
		err++;
	}
	
	
	if(err == 0){
		 addStudent(event);
	}else{
		return false;
	}
}

const addStudent = (e) => {
	e.preventDefault();
	$("#addStudentHistory").prop("disabled", true);
	const student = $("#student").val();
	const teacher = $("#teacher").val();
	const year = $("#year").val();
	var grade = $("#grade").val();
	const s_class = $("#class").val();
	 
	 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/studentHistoryController?student="+student+"&teacher="+teacher+"&year="+year
		+"&grade="+grade+"&class="+s_class,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Details Saved!',
					'success'
				);
				clearForm();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			$("#addStudentHistory").prop("disabled", false);
		}
	});
};

const clearForm = () => {
	$("#student_history").trigger('reset');
};



const loadStudentList = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/c",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
			 
					$("#student").append(`<option value="${element.id}">${element.name}</option>`);
				});
			} 
		}
	});
};

const loadTeacherList = () => {

	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/t",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#teacher").append(`<option value="${element.id}">${element.name}</option>`);
				});
			} 
		}
	});
};
