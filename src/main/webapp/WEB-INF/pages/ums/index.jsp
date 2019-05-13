<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="_csrf_parameter" content="${_csrf.parameterName}" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico">
<title>用户管理首页</title>
<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap.css">

<!-- Bootstrap 4.0-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/css/bootstrap-extend.css">

<!-- theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/master_style.css">

<!-- MinimalLite Admin skins. choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/skins/_all-skins.css">

<!-- Morris.js charts CSS -->
<link
	href="${pageContext.request.contextPath}/assets/vendor_components/morris.js/morris.css"
	rel="stylesheet" />
<!-- Vector CSS -->
<link
	href="${pageContext.request.contextPath}/assets/vendor_components/jvectormap/lib2/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<!-- date picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor_plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css">
</head>

<body class="hold-transition skin-green sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<a href="index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<b class="logo-mini"> <span class="light-logo"><img
						src="../images/aries-light.png" alt="logo"></span> <span
					class="dark-logo"><img src="../images/aries-dark.png"
						alt="logo"></span>
			</b> <!-- logo for regular state and mobile devices --> <span
				class="logo-lg"> <img src="../images/logo-light-text.png"
					alt="logo" class="light-logo"> <img
					src="../images/logo-dark-text.png" alt="logo" class="dark-logo">
			</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<li class="search-box"><a class="nav-link hidden-sm-down"
							href="javascript:void(0)"><i class="mdi mdi-magnify"></i></a>
							<form class="app-search" style="display: none;">
								<input type="text" class="form-control"
									placeholder="Search &amp; enter"> <a class="srh-btn"><i
									class="ti-close"></i></a>
							</form></li>

						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="mdi mdi-email"></i>
						</a>
							<ul class="dropdown-menu scale-up">
								<li class="header">You have 5 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu inner-content-div">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="../images/user2-160x160.jpg"
														class="rounded-circle" alt="User Image">
												</div>
												<div class="mail-contnet">
													<h4>
														Lorem Ipsum <small><i class="fa fa-clock-o"></i>
															15 mins</small>
													</h4>
													<span>Lorem ipsum dolor sit amet, consectetur
														adipiscing elit.</span>
												</div>
										</a>
										</li>
										<!-- end message -->
										<li><a href="#">
												<div class="pull-left">
													<img src="../images/user3-128x128.jpg"
														class="rounded-circle" alt="User Image">
												</div>
												<div class="mail-contnet">
													<h4>
														Nullam tempor <small><i class="fa fa-clock-o"></i>
															4 hours</small>
													</h4>
													<span>Curabitur facilisis erat quis metus congue
														viverra.</span>
												</div>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../images/user4-128x128.jpg"
														class="rounded-circle" alt="User Image">
												</div>
												<div class="mail-contnet">
													<h4>
														Proin venenatis <small><i class="fa fa-clock-o"></i>
															Today</small>
													</h4>
													<span>Vestibulum nec ligula nec quam sodales rutrum
														sed luctus.</span>
												</div>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../images/user3-128x128.jpg"
														class="rounded-circle" alt="User Image">
												</div>
												<div class="mail-contnet">
													<h4>
														Praesent suscipit <small><i class="fa fa-clock-o"></i>
															Yesterday</small>
													</h4>
													<span>Curabitur quis risus aliquet, luctus arcu nec,
														venenatis neque.</span>
												</div>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../images/user4-128x128.jpg"
														class="rounded-circle" alt="User Image">
												</div>
												<div class="mail-contnet">
													<h4>
														Donec tempor <small><i class="fa fa-clock-o"></i>
															2 days</small>
													</h4>
													<span>Praesent vitae tellus eget nibh lacinia
														pretium.</span>
												</div>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">See all e-Mails</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="mdi mdi-bell"></i>
						</a>
							<ul class="dropdown-menu scale-up">
								<li class="header">You have 7 notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu inner-content-div">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												Curabitur id eros quis nunc suscipit blandit.
										</a></li>
										<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
												Duis malesuada justo eu sapien elementum, in semper diam
												posuere.
										</a></li>
										<li><a href="#"> <i class="fa fa-users text-red"></i>
												Donec at nisi sit amet tortor commodo porttitor pretium a
												erat.
										</a></li>
										<li><a href="#"> <i
												class="fa fa-shopping-cart text-green"></i> In gravida
												mauris et nisi
										</a></li>
										<li><a href="#"> <i class="fa fa-user text-red"></i>
												Praesent eu lacus in libero dictum fermentum.
										</a></li>
										<li><a href="#"> <i class="fa fa-user text-red"></i>
												Nunc fringilla lorem
										</a></li>
										<li><a href="#"> <i class="fa fa-user text-red"></i>
												Nullam euismod dolor ut quam interdum, at scelerisque ipsum
												imperdiet.
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
						<!-- Tasks: style can be found in dropdown.less -->
						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="mdi mdi-message"></i>
						</a>
							<ul class="dropdown-menu scale-up">
								<li class="header">You have 6 tasks</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu inner-content-div">
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Lorem ipsum dolor sit amet <small class="pull-right">30%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua"
														style="width: 30%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">30% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Vestibulum nec ligula <small class="pull-right">20%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-danger"
														style="width: 20%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Donec id leo ut ipsum <small class="pull-right">70%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-light-blue"
														style="width: 70%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">70% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Praesent vitae tellus <small class="pull-right">40%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-yellow"
														style="width: 40%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">40% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Nam varius sapien <small class="pull-right">80%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-red"
														style="width: 80%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">80% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Nunc fringilla <small class="pull-right">90%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-primary"
														style="width: 90%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">90% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all tasks</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../images/user5-128x128.jpg"
								class="user-image rounded-circle" alt="User Image">
						</a>
							<ul class="dropdown-menu scale-up">
								<!-- User image -->
								<li class="user-header"><img
									src="../images/user5-128x128.jpg"
									class="float-left rounded-circle" alt="User Image">

									<p>
										Juliya Brus <small class="mb-5">jb@gmail.com</small> <a
											href="#" class="btn btn-danger btn-sm btn-rounded">View
											Profile</a>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row no-gutters">
										<div class="col-12 text-left">
											<a href="#"><i class="ion ion-person"></i> My Profile</a>
										</div>
										<div class="col-12 text-left">
											<a href="#"><i class="ion ion-email-unread"></i> Inbox</a>
										</div>
										<div class="col-12 text-left">
											<a href="#"><i class="ion ion-settings"></i> Setting</a>
										</div>
										<div role="separator" class="divider col-12"></div>
										<div class="col-12 text-left">
											<a href="#"><i class="ti-settings"></i> Account Setting</a>
										</div>
										<div role="separator" class="divider col-12"></div>
										<div class="col-12 text-left">
											<a href="#"><i class="fa fa-power-off"></i> Logout</a>
										</div>
									</div> <!-- /.row -->
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-cog fa-spin"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>

		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="user-profile treeview"><a href="index.html"> <img
							src="../images/user5-128x128.jpg" alt="user"> <span>Juliya
								Brus</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="javascript:void()"><i
									class="fa fa-user mr-5"></i>My Profile </a></li>
							<li><a href="javascript:void()"><i
									class="fa fa-money mr-5"></i>My Balance</a></li>
							<li><a href="javascript:void()"><i
									class="fa fa-envelope-open mr-5"></i>Inbox</a></li>
							<li><a href="javascript:void()"><i
									class="fa fa-cog mr-5"></i>Account Setting</a></li>
							<li><a href="javascript:void()"><i
									class="fa fa-power-off mr-5"></i>Logout</a></li>
						</ul></li>
					<li class="header nav-small-cap">PERSONAL</li>
					<li class="active"><a href="index.html"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a></li>
					<li class="treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>App</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/app/app-chat.html"><i
									class="fa fa-circle-thin"></i>Chat app</a></li>
							<li><a href="pages/app/app-contact.html"><i
									class="fa fa-circle-thin"></i>Contact / Employee</a></li>
							<li><a href="pages/app/app-ticket.html"><i
									class="fa fa-circle-thin"></i>Support Ticket</a></li>
							<li><a href="pages/app/calendar.html"><i
									class="fa fa-circle-thin"></i>Calendar</a></li>
							<li><a href="pages/app/profile.html"><i
									class="fa fa-circle-thin"></i>Profile</a></li>
							<li><a href="pages/app/userlist-grid.html"><i
									class="fa fa-circle-thin"></i>Userlist Grid</a></li>
							<li><a href="pages/app/userlist.html"><i
									class="fa fa-circle-thin"></i>Userlist</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-envelope"></i> <span>Mailbox</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/mailbox/mailbox.html"><i
									class="fa fa-circle-thin"></i>Inbox</a></li>
							<li><a href="pages/mailbox/compose.html"><i
									class="fa fa-circle-thin"></i>Compose</a></li>
							<li><a href="pages/mailbox/read-mail.html"><i
									class="fa fa-circle-thin"></i>Read</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
							<span>UI Elements</span> <span class="pull-right-container">
								<i class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/UI/badges.html"><i
									class="fa fa-circle-thin"></i>Badges</a></li>
							<li><a href="pages/UI/border-utilities.html"><i
									class="fa fa-circle-thin"></i>Border</a></li>
							<li><a href="pages/UI/buttons.html"><i
									class="fa fa-circle-thin"></i>Buttons</a></li>
							<li><a href="pages/UI/bootstrap-switch.html"><i
									class="fa fa-circle-thin"></i>Bootstrap Switch</a></li>
							<li><a href="pages/UI/cards.html"><i
									class="fa fa-circle-thin"></i>User Card</a></li>
							<li><a href="pages/UI/color-utilities.html"><i
									class="fa fa-circle-thin"></i>Color</a></li>
							<li><a href="pages/UI/date-paginator.html"><i
									class="fa fa-circle-thin"></i>Date Paginator</a></li>
							<li><a href="pages/UI/dropdown.html"><i
									class="fa fa-circle-thin"></i>Dropdown</a></li>
							<li><a href="pages/UI/dropdown-grid.html"><i
									class="fa fa-circle-thin"></i>Dropdown Grid</a></li>
							<li><a href="pages/UI/general.html"><i
									class="fa fa-circle-thin"></i>General</a></li>
							<li><a href="pages/UI/icons.html"><i
									class="fa fa-circle-thin"></i>Icons</a></li>
							<li><a href="pages/UI/media-advanced.html"><i
									class="fa fa-circle-thin"></i>Advanced Medias</a></li>
							<li><a href="pages/UI/modals.html"><i
									class="fa fa-circle-thin"></i>Modals</a></li>
							<li><a href="pages/UI/nestable.html"><i
									class="fa fa-circle-thin"></i>Nestable</a></li>
							<li><a href="pages/UI/notification.html"><i
									class="fa fa-circle-thin"></i>Notification</a></li>
							<li><a href="pages/UI/portlet-draggable.html"><i
									class="fa fa-circle-thin"></i>Draggable Portlets</a></li>
							<li><a href="pages/UI/ribbons.html"><i
									class="fa fa-circle-thin"></i>Ribbons</a></li>
							<li><a href="pages/UI/sliders.html"><i
									class="fa fa-circle-thin"></i>Sliders</a></li>
							<li><a href="pages/UI/sweatalert.html"><i
									class="fa fa-circle-thin"></i>Sweet Alert</a></li>
							<li><a href="pages/UI/tab.html"><i
									class="fa fa-circle-thin"></i>Tabs</a></li>
							<li><a href="pages/UI/timeline.html"><i
									class="fa fa-circle-thin"></i>Timeline</a></li>
							<li><a href="pages/UI/timeline-horizontal.html"><i
									class="fa fa-circle-thin"></i>Horizontal Timeline</a></li>
						</ul></li>
					<li class="header nav-small-cap">FORMS, TABLE & LAYOUTS</li>
					<li class="treeview"><a href="#"> <i class="fa fa-bars"></i>
							<span>Widgets</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/widgets/blog.html"><i
									class="fa fa-circle-thin"></i>Blog</a></li>
							<li><a href="pages/widgets/chart.html"><i
									class="fa fa-circle-thin"></i>Chart</a></li>
							<li><a href="pages/widgets/list.html"><i
									class="fa fa-circle-thin"></i>List</a></li>
							<li><a href="pages/widgets/social.html"><i
									class="fa fa-circle-thin"></i>Social</a></li>
							<li><a href="pages/widgets/statistic.html"><i
									class="fa fa-circle-thin"></i>Statistic</a></li>
							<li><a href="pages/widgets/weather.html"><i
									class="fa fa-circle-thin"></i>Weather</a></li>
							<li><a href="pages/widgets/widgets.html"><i
									class="fa fa-circle-thin"></i>Widgets</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
							<span>Layout Options</span> <span class="pull-right-container">
								<i class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/layout/boxed.html"><i
									class="fa fa-circle-thin"></i>Boxed</a></li>
							<li><a href="pages/layout/fixed.html"><i
									class="fa fa-circle-thin"></i>Fixed</a></li>
							<li><a href="pages/layout/collapsed-sidebar.html"><i
									class="fa fa-circle-thin"></i>Collapsed Sidebar</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-square-o"></i> <span>Box</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/box/advanced.html"><i
									class="fa fa-circle-thin"></i>Advanced</a></li>
							<li><a href="pages/box/basic.html"><i
									class="fa fa-circle-thin"></i>Basic</a></li>
							<li><a href="pages/box/color.html"><i
									class="fa fa-circle-thin"></i>Color</a></li>
							<li><a href="pages/box/group.html"><i
									class="fa fa-circle-thin"></i>Group</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-pie-chart"></i> <span>Charts</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/charts/chartjs.html"><i
									class="fa fa-circle-thin"></i>ChartJS</a></li>
							<li><a href="pages/charts/flot.html"><i
									class="fa fa-circle-thin"></i>Flot</a></li>
							<li><a href="pages/charts/inline.html"><i
									class="fa fa-circle-thin"></i>Inline charts</a></li>
							<li><a href="pages/charts/morris.html"><i
									class="fa fa-circle-thin"></i>Morris</a></li>
							<li><a href="pages/charts/peity.html"><i
									class="fa fa-circle-thin"></i>Peity</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>Forms</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/forms/advanced.html"><i
									class="fa fa-circle-thin"></i>Advanced Elements</a></li>
							<li><a href="pages/forms/code-editor.html"><i
									class="fa fa-circle-thin"></i>Code Editor</a></li>
							<li><a href="pages/forms/editor-markdown.html"><i
									class="fa fa-circle-thin"></i>Markdown</a></li>
							<li><a href="pages/forms/editors.html"><i
									class="fa fa-circle-thin"></i>Editors</a></li>
							<li><a href="pages/forms/form-validation.html"><i
									class="fa fa-circle-thin"></i>Form Validation</a></li>
							<li><a href="pages/forms/form-wizard.html"><i
									class="fa fa-circle-thin"></i>Form Wizard</a></li>
							<li><a href="pages/forms/general.html"><i
									class="fa fa-circle-thin"></i>General Elements</a></li>
							<li><a href="pages/forms/mask.html"><i
									class="fa fa-circle-thin"></i>Formatter</a></li>
							<li><a href="pages/forms/xeditable.html"><i
									class="fa fa-circle-thin"></i>Xeditable Editor</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-table"></i>
							<span>Tables</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/tables/simple.html"><i
									class="fa fa-circle-thin"></i>Simple tables</a></li>
							<li><a href="pages/tables/data.html"><i
									class="fa fa-circle-thin"></i>Data tables</a></li>
							<li><a href="pages/tables/editable-tables.html"><i
									class="fa fa-circle-thin"></i>Editable Tables</a></li>
							<li><a href="pages/tables/table-color.html"><i
									class="fa fa-circle-thin"></i>Table Color</a></li>
						</ul></li>
					<li><a href="pages/email/index.html"> <i
							class="fa fa-envelope-open-o"></i> <span>Emails</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a></li>
					<li class="header nav-small-cap">EXTRA COMPONENTS</li>
					<li class="treeview"><a href="#"> <i class="fa fa-map"></i>
							<span>Map</span> <span class="pull-right-container"> <i
								class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/map/map-google.html"><i
									class="fa fa-circle-thin"></i>Google Map</a></li>
							<li><a href="pages/map/map-vector.html"><i
									class="fa fa-circle-thin"></i>Vector Map</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-plug"></i>
							<span>Extension</span> <span class="pull-right-container">
								<i class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/extension/fullscreen.html"><i
									class="fa fa-circle-thin"></i>Fullscreen</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-file"></i>
							<span>Sample Pages</span> <span class="pull-right-container">
								<i class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/samplepage/blank.html"><i
									class="fa fa-circle-thin"></i>Blank</a></li>
							<li><a href="pages/samplepage/coming-soon.html"><i
									class="fa fa-circle-thin"></i>Coming Soon</a></li>
							<li><a href="pages/samplepage/custom-scroll.html"><i
									class="fa fa-circle-thin"></i>Custom Scrolls</a></li>
							<li><a href="pages/samplepage/faq.html"><i
									class="fa fa-circle-thin"></i>FAQ</a></li>
							<li><a href="pages/samplepage/gallery.html"><i
									class="fa fa-circle-thin"></i>Gallery</a></li>
							<li><a href="pages/samplepage/invoice.html"><i
									class="fa fa-circle-thin"></i>Invoice</a></li>
							<li><a href="pages/samplepage/lightbox.html"><i
									class="fa fa-circle-thin"></i>Lightbox Popup</a></li>
							<li><a href="pages/samplepage/pace.html"><i
									class="fa fa-circle-thin"></i>Pace</a></li>
							<li><a href="pages/samplepage/pricing.html"><i
									class="fa fa-circle-thin"></i>Pricing</a></li>
							<li class="treeview"><a href="#"><i
									class="fa fa-circle-thin"></i>Authentication <span
									class="pull-right-container"> <i
										class="fa fa-angle-right pull-right"></i>
								</span> </a>
								<ul class="treeview-menu">
									<li><a href="pages/samplepage/login.html"><i
											class="fa fa-circle"></i>Login</a></li>
									<li><a href="pages/samplepage/register.html"><i
											class="fa fa-circle"></i>Register</a></li>
									<li><a href="pages/samplepage/lockscreen.html"><i
											class="fa fa-circle"></i>Lockscreen</a></li>
									<li><a href="pages/samplepage/user-pass.html"><i
											class="fa fa-circle"></i>Recover password</a></li>
								</ul></li>
							<li class="treeview"><a href="#"><i
									class="fa fa-circle-thin"></i>Error Pages <span
									class="pull-right-container"> <i
										class="fa fa-angle-right pull-right"></i>
								</span> </a>
								<ul class="treeview-menu">
									<li><a href="pages/samplepage/404.html"><i
											class="fa fa-circle"></i>404</a></li>
									<li><a href="pages/samplepage/500.html"><i
											class="fa fa-circle"></i>500</a></li>
									<li><a href="pages/samplepage/maintenance.html"><i
											class="fa fa-circle"></i>Maintenance</a></li>
								</ul></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-share"></i>
							<span>Multilevel</span> <span class="pull-right-container">
								<i class="fa fa-angle-right pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="#">Level One</a></li>
							<li class="treeview"><a href="#">Level One <span
									class="pull-right-container"> <i
										class="fa fa-angle-right pull-right"></i>
								</span>
							</a>
								<ul class="treeview-menu">
									<li><a href="#">Level Two</a></li>
									<li class="treeview"><a href="#">Level Two <span
											class="pull-right-container"> <i
												class="fa fa-angle-right pull-right"></i>
										</span>
									</a>
										<ul class="treeview-menu">
											<li><a href="#">Level Three</a></li>
											<li><a href="#">Level Three</a></li>
										</ul></li>
								</ul></li>
							<li><a href="#">Level One</a></li>
						</ul></li>

				</ul>
			</section>
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Dashboard <small>Control panel</small>
				</h1>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<!---//////////////////////--->
				<div class="row">
					<div class="col-12 ">
						<div class="box">
							<div class="row no-gutters py-2">

								<div class="col-sm-6 col-lg-3">
									<div class="box-body br-1 border-light">
										<div class="flexbox mb-1">
											<span> <i class="ion-person font-size-26"></i><br>
												New Users
											</span> <span class="text-primary font-size-40">34</span>
										</div>
										<div class="progress progress-xxs mt-10 mb-0">
											<div class="progress-bar" role="progressbar"
												style="width: 35%; height: 4px;" aria-valuenow="35"
												aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>


								<div class="col-sm-6 col-lg-3 hidden-down">
									<div class="box-body br-1 border-light">
										<div class="flexbox mb-1">
											<span> <i class="ion-document font-size-26"></i><br>
												Today Invoices
											</span> <span class="text-info font-size-40">18</span>
										</div>
										<div class="progress progress-xxs mt-10 mb-0">
											<div class="progress-bar bg-info" role="progressbar"
												style="width: 55%; height: 4px;" aria-valuenow="55"
												aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>


								<div class="col-sm-6 col-lg-3 d-none d-lg-block">
									<div class="box-body br-1 border-light">
										<div class="flexbox mb-1">
											<span> <i class="ion-information font-size-26"></i><br>
												Open Issues
											</span> <span class="text-warning font-size-40">46</span>
										</div>
										<div class="progress progress-xxs mt-10 mb-0">
											<div class="progress-bar bg-warning" role="progressbar"
												style="width: 65%; height: 4px;" aria-valuenow="65"
												aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>


								<div class="col-sm-6 col-lg-3 d-none d-lg-block">
									<div class="box-body">
										<div class="flexbox mb-1">
											<span> <i class="ion-folder font-size-26"></i><br>
												New Projects
											</span> <span class="text-danger font-size-40">12</span>
										</div>
										<div class="progress progress-xxs mt-10 mb-0">
											<div class="progress-bar bg-danger" role="progressbar"
												style="width: 40%; height: 4px;" aria-valuenow="40"
												aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>
					<!-- /.col -->

				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-xl-6 col-12">
						<!-- AREA CHART -->
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">Area Chart</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool"
										data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool"
										data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body">
								<div class="chart">
									<canvas id="areaChart" style="height: 350px"></canvas>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>

					<div class="col-xl-6 col-12">
						<!-- AREA CHART -->
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">Yeary Sales</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool"
										data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool"
										data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body">
								<ul class="list-inline text-right">
									<li>
										<h5>
											<i class="fa fa-circle mr-5" style="color: #26c6da;"></i>iPhone
										</h5>
									</li>
									<li>
										<h5>
											<i class="fa fa-circle mr-5" style="color: #fc4b6c;"></i>iPad
										</h5>
									</li>
									<li>
										<h5>
											<i class="fa fa-circle mr-5" style="color: #398bf7;"></i>iPod
										</h5>
									</li>
								</ul>
								<div id="morris-area-chart" style="height: 310px;"></div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-md-4 col-12">
						<div class="box box-inverse" style="background-color: #3b5998">
							<div class="box-header no-border">
								<span class="fa fa-facebook font-size-30"></span>
								<div class="box-tools pull-right">
									<h5 class="box-title box-title-bold">Facebook feed</h5>
								</div>
							</div>

							<blockquote
								class="blockquote blockquote-inverse no-border m-0 py-15">
								<p>Holisticly benchmark plug imperatives for multifunctional
									deliverables. Seamlessly incubate cross functional action.</p>
								<div class="flexbox">
									<time class="text-white" datetime="2017-11-21 20:00">21
										November, 2017</time>
									<span><i class="fa fa-heart"></i> 75</span>
								</div>
							</blockquote>
						</div>
					</div>
					<div class="col-md-4 col-12">
						<div class="box box-inverse box-carousel slide"
							data-ride="carousel" style="background-color: #00aced">
							<div class="box-header no-border">
								<span class="fa fa-twitter font-size-30"></span>
								<div class="box-tools pull-right">
									<h5 class="box-title box-title-bold">Twitter feed</h5>
								</div>
							</div>

							<div class="carousel-inner">
								<blockquote
									class="blockquote blockquote-inverse no-border m-0 py-15 carousel-item active">
									<p>Holisticly benchmark plug imperatives for
										multifunctional deliverables. Seamlessly incubate cross
										functional action.</p>
									<div class="flexbox">
										<time class="text-white" datetime="2017-11-22 20:00">22
											November, 2017</time>
										<span><i class="fa fa-heart"></i> 62</span>
									</div>
								</blockquote>

								<blockquote
									class="blockquote blockquote-inverse no-border m-0 py-15 carousel-item">
									<p>Uniquely revolutionize leveraged catalysts for change
										for world-class web services. Efficiently underwhelm
										competitive.</p>
									<div class="flexbox">
										<time class="text-white" datetime="2017-11-22 20:00">22
											November, 2017</time>
										<span><i class="fa fa-heart"></i> 45</span>
									</div>
								</blockquote>

								<blockquote
									class="blockquote blockquote-inverse no-border m-0 py-15 carousel-item">
									<p>Enthusiastically optimize cross-media manufactured
										products without process-centric web services. Conveniently.</p>
									<div class="flexbox">
										<time class="text-white" datetime="2017-11-22 20:00">22
											November, 2017</time>
										<span><i class="fa fa-heart"></i> 65</span>
									</div>
								</blockquote>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-12">
						<div class="box box-inverse bg-red">
							<div class="box-header no-border">
								<span class="fa fa-google-plus font-size-30"></span>
								<div class="box-tools pull-right">
									<h5 class="box-title box-title-bold">Google Plus</h5>
								</div>
							</div>

							<blockquote
								class="blockquote blockquote-inverse no-border m-0 py-15">
								<p>Holisticly benchmark plug imperatives for multifunctional
									deliverables. Seamlessly incubate cross functional action.</p>
								<div class="flexbox">
									<time class="text-white" datetime="2017-11-21 20:00">21
										November, 2017</time>
									<span><i class="fa fa-heart"></i> 75</span>
								</div>
							</blockquote>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-6 col-12">
						<div class="row">
							<div class="col-md-6 col-12">
								<div class="box box-body">
									<div class="flexbox">
										<h6 class="text-uppercase">Analysis</h6>
										<h6>
											<i
												class="ion-android-arrow-dropup text-success font-size-18 mr-1"></i>
											%20
										</h6>
									</div>

									<ul class="flexbox flex-justified text-center my-30">
										<li class="br-1">
											<div class="font-size-18">%76.58</div> <small>All
												Time</small>
										</li>

										<li class="br-1">
											<div class="font-size-18">%35.12</div> <small>Last
												Month</small>
										</li>

										<li>
											<div class="font-size-18">%6.66</div> <small>Today</small>
										</li>
									</ul>

									<div id="baralc" class="text-center">
										<canvas width="236" height="80"
											style="display: inline-block; width: 236px; height: 80px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-12">
								<div class="box bg-blue">
									<div class="box-body text-white">
										<div class="font-size-50 font-weight-200">6,374</div>
										<p>Increase in page views</p>
									</div>

									<div id="lineIncrease">
										<canvas width="524" height="140"
											style="display: inline-block; width: 524.328px; height: 140px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>
							<div class="col-12">
								<div class="box box-body">
									<div class="flexbox">
										<h6 class="text-uppercase">Analysis</h6>
										<h6>
											<i
												class="ion-android-arrow-dropup text-success font-size-18 mr-1"></i>
											%20
										</h6>
									</div>

									<ul class="flexbox flex-justified text-center">
										<li class="br-1">
											<div class="font-size-18">953</div> <small>New York</small>
										</li>

										<li class="br-1">
											<div class="font-size-18">813</div> <small>Los
												Angeles</small>
										</li>

										<li>
											<div class="font-size-18">369</div> <small>Dallas</small>
										</li>
									</ul>

									<div id="linearea">
										<canvas width="339" height="80"
											style="display: inline-block; width: 339px; height: 80px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>

						</div>
					</div>

					<div class="col-md-3 col-12">
						<div class="box">
							<div class="box-header with-border">
								<h5 class="box-title">Top Locations</h5>
								<div class="box-tools pull-right">
									<ul class="card-controls">
										<li class="dropdown"><a data-toggle="dropdown" href="#"><i
												class="ion-android-more-vertical"></i></a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item active" href="#">Today</a> <a
													class="dropdown-item" href="#">Yesterday</a> <a
													class="dropdown-item" href="#">Last week</a> <a
													class="dropdown-item" href="#">Last month</a>
											</div></li>
										<li><a href="#" class="link card-btn-reload"
											data-toggle="tooltip" title="" data-original-title="Refresh"><i
												class="fa fa-circle-thin"></i></a></li>
									</ul>
								</div>
							</div>

							<div class="box-body">
								<div class="text-center py-20">
									<div class="donut"
										data-peity='{ "fill": ["#7460ee", "#26c6da", "#fc4b6c"], "radius": 133, "innerRadius": 80  }'>9,6,5</div>
								</div>

								<ul class="flexbox flex-justified text-center mt-30">
									<li class="br-1">
										<div class="font-size-20 text-primary">953</div> <small>New
											York</small>
									</li>

									<li class="br-1">
										<div class="font-size-20 text-success">813</div> <small>Los
											Angeles</small>
									</li>

									<li>
										<div class="font-size-20 text-danger">369</div> <small>Dallas</small>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">Current Visitors</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div id="uk" style="height: 378px"></div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>

				<div class="row">

					<div class="col-md-6 col-lg-4">
						<div class="box box-body">
							<div class="flexbox">
								<div id="linechart">1,4,3,7,6,4,8,9,6,8,12</div>
								<div class="text-right">
									<span>New Users</span><br> <span> <i
										class="ion-ios-arrow-up text-success"></i> <span
										class="font-size-18 ml-1">113</span>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6 col-lg-4">
						<div class="box box-body">
							<div class="flexbox">
								<div id="barchart">1,4,3,7,6,4,8,9,6,8,12</div>
								<div class="text-right">
									<span>Monthly Sale</span><br> <span> <i
										class="ion-ios-arrow-up text-success"></i> <span
										class="font-size-18 ml-1">%80</span>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6 col-lg-4">
						<div class="box box-body">
							<div class="flexbox">
								<div id="discretechart">1,4,3,7,6,4,8,9,6,8,12</div>
								<div class="text-right">
									<span>Impressions</span><br> <span> <i
										class="ion-ios-arrow-up text-success"></i> <span
										class="font-size-18 ml-1">%80</span>
									</span>
								</div>
							</div>
						</div>
					</div>

				</div>




			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right d-none d-sm-inline-block">
				<ul
					class="nav nav-primary nav-dotted nav-dot-separated justify-content-center justify-content-md-end">
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)">FAQ</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://themeforest.net/item/minimal-lite-responsive-bootstrap-4-admin-dashboard-webapp-template/21241896">Purchase
							Now</a></li>
				</ul>
			</div>
			&copy; 2017 <a href="https://www.multipurposethemes.com/">Multi-Purpose
				Themes</a>. All Rights Reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="nav-item"><a href="#control-sidebar-home-tab"
					data-toggle="tab"><i class="fa fa-home"></i></a></li>
				<li class="nav-item"><a href="#control-sidebar-settings-tab"
					data-toggle="tab"><i class="fa fa-cog fa-spin"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Admin Birthday</h4>

									<p>Will be July 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Jhone Updated His
										Profile</h4>

									<p>New Email : jhone_doe@demo.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Disha Joined
										Mailing List</h4>

									<p>disha@demo.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Code Change</h4>

									<p>Execution time 15 Days</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Web Design <span class="label label-danger pull-right">40%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 40%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Update Data <span class="label label-success pull-right">75%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 75%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Order Process <span class="label label-warning pull-right">89%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 89%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Development <span class="label label-primary pull-right">72%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 72%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<input type="checkbox" id="report_panel" class="chk-col-grey">
							<label for="report_panel" class="control-sidebar-subheading ">Report
								panel usage</label>

							<p>general settings information</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<input type="checkbox" id="allow_mail" class="chk-col-grey">
							<label for="allow_mail" class="control-sidebar-subheading ">Mail
								redirect</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<input type="checkbox" id="expose_author" class="chk-col-grey">
							<label for="expose_author" class="control-sidebar-subheading ">Expose
								author name</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<input type="checkbox" id="show_me_online" class="chk-col-grey">
							<label for="show_me_online" class="control-sidebar-subheading ">Show
								me as online</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<input type="checkbox" id="off_notifications"
								class="chk-col-grey"> <label for="off_notifications"
								class="control-sidebar-subheading ">Turn off
								notifications</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> <a
								href="javascript:void(0)" class="text-red margin-r-5"><i
									class="fa fa-trash-o"></i></a> Delete chat history
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>

	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/jquery/dist/jquery.js"></script>

	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/jquery-ui/jquery-ui.js"></script>

	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>

	<!-- popper -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/popper/dist/popper.min.js"></script>

	<!-- Bootstrap 4.0-->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/bootstrap/dist/js/bootstrap.js"></script>

	<!-- Morris.js charts -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/raphael/raphael.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor_components/morris.js/morris.min.js"></script>

	<!-- ChartJS -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/chart-js/chart.js"></script>

	<!-- Sparkline -->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/jquery-sparkline/dist/jquery.sparkline.js"></script>

	<!-- Slimscroll -->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/jquery-slimscroll/jquery.slimscroll.js"></script>

	<!-- FastClick -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/fastclick/lib/fastclick.js"></script>

	<!-- peity -->
	<script src="${pageContext.request.contextPath}/assets/vendor_components/jquery.peity/jquery.peity.js"></script>

	<!-- Vector map JavaScript -->
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/jvectormap/lib2/jquery-jvectormap-2.0.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor_components/jvectormap/lib2/jquery-jvectormap-uk-mill-en.js"></script>

	<!-- MinimalLite Admin App -->
	<script src="${pageContext.request.contextPath}/js/template.js"></script>

	<!-- MinimalLite Admin dashboard demo (This is only for demo purposes) -->
	<script src="${pageContext.request.contextPath}/js/pages/dashboard.js"></script>

	<!-- MinimalLite Admin for demo purposes -->
	<script src="${pageContext.request.contextPath}/js/demo.js"></script>

</body>
</html>
