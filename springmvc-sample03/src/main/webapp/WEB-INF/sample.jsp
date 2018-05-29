<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

    <title>Plupload - Queue widget example</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/js/jquery.plupload.queue/css/jquery.plupload.queue.css"
          type="text/css" media="screen"/>

    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>

    <!-- production -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plupload.full.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>

    <!-- debug
    <script type="text/javascript" src="../../js/moxie.js"></script>
    <script type="text/javascript" src="../../js/plupload.dev.js"></script>
    <script type="text/javascript" src="../../js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
    -->


</head>
<body style="font: 13px Verdana; background: #eee; color: #333">

<form method="post" action="/submit">
    <div id="uploader">
        <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
    </div>
    <input type="submit" value="Send"/>
</form>

<script type="text/javascript">
    $(function () {

        // Setup html5 version
        $("#uploader").pluploadQueue({
            // General settings
            runtimes: 'html5,flash,silverlight,html4',
            url: '/upload',
            chunk_size: '1mb',
            rename: true,
            dragdrop: true,

            filters: {
                // Maximum file size
                max_file_size: '10mb',
                // Specify what files to browse for
                mime_types: [
                    {title: "Image files", extensions: "jpg,jpeg,gif,png"},
                    {title: "Zip files", extensions: "zip"}
                ]
            },

            // Resize images on clientside if we can
            resize: {width: 320, height: 240, quality: 90},

            flash_swf_url: '${pageContext.request.contextPath}/static/js/Moxie.swf',
            silverlight_xap_url: '${pageContext.request.contextPath}/static/js/Moxie.xap'

        });

    });
</script>

</body>
</html>
