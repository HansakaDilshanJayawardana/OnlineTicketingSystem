<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Add Passenger</title>
  <!-- Custom fonts for this template-->
  <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <jsp:include page="../common/sidebar.jsp" />
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>


        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">

            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
              </a>
            </div>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <h1 class="h3 mb-4 text-gray-800">Request a Ticket</h1>


        <!-- Form begins -->
        <form class="user" id="addTicket">

          <div class="form-group">
            <label>Reference ID</label>
            <input type="text" id="refId" name="refId" class="form-control form-control-user" placeholder="Reference ID">
          </div>

          <div class="form-group">
          <label for="start">Starting Point</label>
          <select class="form-control"  name="start" id="start">
            <option value="colombo">Colombo</option>
            <option value="Badulla">Badulla</option>
            <option value="Ella">Ella</option>
            <option value="NuwaraEliya">Nuwara-Eliya</option>
            <option value="Kandy">Kandy</option>
            <option value="rathnapura">Rathnapura</option>
          </select>
          </div>

          <div class="form-group">
            <label for="Destinationcars">Destination</label>
            <select class="form-control" name="end" id="Destinationcars">
              <option value="colombo">Colombo</option>
              <option value="Badulla">Badulla</option>
              <option value="Ella">Ella</option>
              <option value="NuwaraEliya">Nuwara-Eliya</option>
              <option value="Kandy">Kandy</option>
              <option value="rathnapura">Rathnapura</option>
            </select>
          </div>

          <div class="form-group">
            <label>Booking Date</label>
            <input type="date" id="bookingdate" name="bookingdate"  min="2000-01-01" class="form-control form-control-user" id="exampleInputEmail">
          </div>

          <div class="form-group">
            <label>Number of Tickets</label>
            <input type="number" min="1" max="20" id="tickets" name="tickets" class="form-control form-control-user" placeholder="Number of Tickets">
          </div>

          <input type="submit" id="submitBtn" onclick="validateSubmit(event)" class="btn btn-success btn-user btn-block" value="Request Ticket">
          <hr>
        </form>


      </div>
      <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">

      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../../js/sb-admin-2.min.js"></script>

<script src="../../js/custom/students/addStudent.js"></script>
<script type="text/javascript">


</script>
</body>
</html>
