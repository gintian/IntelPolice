<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>身份辨认</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/identification.css">
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <!-- 头部 start 8-->
        <div id="header">
            <script>
                $('#header').load('public/header.html');
            </script>
        </div>
        <div class="row-fluid">

            <div class="col-md-3" id="info_left">
                <script>
                    $('#info_left').load('public/left_info.html');
                </script>
            </div>
            <div class="col-md-9" id="info_right">
                <div id="info_image_top">
                        <fiedset>
                            <legend>指认照片</legend>
                            <ul>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_1.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_2.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_3.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_4.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_1.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_2.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_3.png" alt=""></div>
                                </li>
                                <li>
                                    <div><img class="img-responsive img-rounded" src="images/head_4.png" alt=""></div>
                                </li>
                            </ul>

                        </fiedset>
                </div>
                <div class="row-fluid" id="info_image_down">
                    <div class="ocl-md-12">
                        <fieldset>
                            <legend>辨认信息</legend>
                            <textarea placeholder="在此输入..."></textarea>
                        </fieldset>
                    </div>
                </div>

            </div>
            <div class="row-fluid">
                <div id="footer">
                    <script>
                        $('#footer').load('public/footer.html');
                    </script>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/js/identification.js"></script>
</body>
</html>
