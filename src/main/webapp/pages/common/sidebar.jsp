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


    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProfile"
           aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>My Profile</span>
        </a>
        <div id="collapseProfile" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header"></h6>
                <a class="collapse-item" href="../Passenger/addPassenger.jsp">Add New Passenger</a>
                <a class="collapse-item" href="../Passenger/ViewPassengers.jsp">View Passengers</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="../Ticket/RequestATicket.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Request a Ticket</span></a>
    </li>

    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="../Ticket/MyJourney.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>My Journey</span></a>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCredits"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wrench"></i>
            <span>My Credits</span>
        </a>
        <div id="collapseCredits" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">

                <a class="collapse-item" href="../Credits/AddCredits.jsp">Add Credits</a>
                <a class="collapse-item" href="../Credits/ViewCredits.jsp">View Credits</a>

            </div>
        </div>
    </li>




    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePayments"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>My Payments</span>
        </a>
        <div id="collapsePayments" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">

                <a class="collapse-item" href="../Payments/DoPayment.jsp">Do a Payment</a>
                <a class="collapse-item" href="../Payments/ViewPayments.jsp">View Payments</a>

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

                <a class="collapse-item" href="../Timetable/AddTimetable.jsp">Add a Timetable</a>
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