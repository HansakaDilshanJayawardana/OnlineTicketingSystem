<script src="../../js/sweetalert2/sweetalert2.all.js"></script>
<script src="../../js/custom/validation.js"></script>
<style>

.bg-gradient-primary {
	background-image: linear-gradient(180deg, #066161 10%, #066161 100%);
}

</style>


<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">TravelWise</div>
    </a>

    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="../Inspector/assignInspector.jsp">
            <i class="fas fa-fw fa-user"></i>
            <span>Assign Inspector</span></a>
    </li>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePayments"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>Reports</span>
        </a>
        <div id="collapsePayments" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="">Statistics Report</a>
                <a class="collapse-item" href="">Passenger Report</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTimetables"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>Bus Timetables</span>
        </a>
        <div id="collapseTimetables" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="../Timetable/AddTimetable.jsp">Add Timetable</a>
                <a class="collapse-item" href="../Timetable/ViewTimetable.jsp">View Timetables</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>



</ul>