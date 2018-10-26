<?php

    if(isset($_POST) && !empty(&_POST)){
        $username = $_POST['username'];
        $password = $_POST['password'];

        if($username =='admin'&& $password =='admin'){
            ?>
        }
        {
            "success": true,
            "secret": "This secret"
        }
        <?php
    }else{
        ?>
    }
    {
        "success": false,
        "message":"Invalid credentials"
    }
        <?php
    }
} else {
    ?>
{
    "success":false,
    "message": "Only POST Access accepted"
}
<?php
}