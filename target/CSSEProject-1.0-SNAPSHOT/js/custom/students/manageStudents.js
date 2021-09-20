$(function() {
	getStudents();
});

const getStudents = () => {
	var txt = $("#txt").val(); //take what is typed in search bar
	var status = $("#status").val(); //current=1, past=0 or all
	var search_opt="admissionNo"; //default
	var grade="-";
	var class_name="-"; 
	var check_status="0"; //not all. only what is searched
	
	if ($("#f_name").prop("checked")) { //if searched by first name
    	search_opt="fullName"; //change line 8 
	} 
	
	//all box
	if ($("#all").prop("checked")) {
    	 check_status="1"; //show all
	}else{
		//if not all get by class
		 grade=$("#grade").val();
	     class_name=$("#class_name").val();
	} 
 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/manageStudent?action=get&txt="+txt+"&search_opt="+search_opt+"&grade="+grade+"&class_name="+class_name+"&check_status="+check_status+"&status="+status, //send to controller
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

const appendStudentTable = (item) => { //get data from student class
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewStudents > tbody').append(textToInsert);
};

//seperated to 3 because it was needed to add into tbody

const addRow = (item) => {
																												//
	const statusChangeBtn = '<button type="button" class="btn btn-info btn-xs" id="' + item.id + 'changeStatus" onclick="changeStatus(\'' + item.id + '\',\'' + item.status + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.id + 'delete" onclick="deleteStudent(\'' + item.id + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Student</button>';
	
	let statusBadge;
	if(item.status == 1){ //get status from student class using item
		statusBadge = '<span class="badge badge-success">Current</span>' //if status is active show green sign
	}else{
		statusBadge = '<span class="badge badge-danger">Past</span>'
	}
	
	let row = '<tr class="table-bordered table-light" id="' + item.id + '">'
		+ '<td>' + item.fullName + '</td>'
		+ '<td>' + item.address + '</td>'
		+ '<td>' + item.dob + '</td>'
		+ '<td>' + item.admissionDate + '</td>'
		+ '<td>' + item.addmissionNo + '</td>'
		+ '<td>' + item.guardianName + '</td>'
		+ '<td>' + item.cno + '</td>'
		+ '<td>' + item.Grade + '</td>'
		+ '<td>' + item.StudentClass + '</td>'
		+ '<td>' + statusBadge + '</td>'
		+ '<td>'
			+ statusChangeBtn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};

const changeStatus = (id, status) => {

	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to change status?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				type: "POST",
				url: "/SchoolManagementSystem/manageStudent?action=update&id="+id+"&status="+status,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getStudents();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};

const deleteStudent = (id) => {
	 
	$("#"+id+"delete").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to delete ?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				type: "POST",
				url: "/SchoolManagementSystem/manageStudent?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getStudents();						
					}
				}
			});
			$("#"+id+"delete").prop("disabled", false);
		}else{
			$("#"+id+"delete").prop("disabled", false);
		}
	})
};

