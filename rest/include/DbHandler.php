<?php

/**
 * Class to handle all db operations
 * This class will have CRUD methods for database tables
 *
 * @author Ravi Tamada
 * @link URL Tutorial link
 */
class DbHandler {

    private $conn;

    function __construct() {
        require_once dirname(__FILE__) . '/DbConnect.php';
        require_once dirname(__FILE__) . '/PassHash.php';
        
        // opening db connection
        $db = new DbConnect();
        $this->conn = $db->connect();
        
    }

    /* ------------- `users` table method ------------------ */

    /**
     * Creating new user
     * @param String $name User full name
     * @param String $email User login email id
     * @param String $password User login password
     */
    public function createUser($name, $email, $password) {
        require_once 'PassHash.php';
        $response = array();

        // First check if user already existed in db
        if (!$this->isUserExists($email)) {
            // Generating password hash
            $password_hash = PassHash::hash($password);

            // Generating API key
            $api_key = $this->generateApiKey();
            $nombrecito=$name;
            $email1=$email;
            // insert query
            $mijin='INSERT INTO users(name, email, password_hash, api_key, status) values(?,?,?,?, 1)';
            $stmt = $this->conn->prepare($mijin);
            $stmt->bind_param("ssss", $nombrecito, $email1, $password_hash, $api_key);

            $result = $stmt->execute();

            $stmt->close();

            // Check for successful insertion
            if ($result) {
                // User successfully inserted
                return USER_CREATED_SUCCESSFULLY;
            } else {
                // Failed to create user
                return USER_CREATE_FAILED;

            }
        } else {
            // User with same email already existed in the db
            return USER_ALREADY_EXISTED;
        }

        return $response;
    }
    
    
        public function createGuser($Nombre,$Gcm,$Seccion) {
       
        $response = array();

        // First check if user already existed in db
        
        //!$this->ifexistsGCM($Gcm)
        if (!$this->ifexistsGCM($Gcm)) {
           
            $mijin='INSERT INTO realTime(nombre, gcm, seccion) values(?,?,?)';
            $stmt = $this->conn->prepare($mijin);
            $stmt->bind_param("sss", $Nombre, $Gcm, $Seccion);

            $result = $stmt->execute();

            $stmt->close();
            

            // Check for successful insertion
            if ($result) {
                // User successfully inserted
                return "Se creo exitosamente";
            } else {
                // Failed to create user
                return "Fallo en la creacion de usuarios";

            }
        } else {
            // User with same email already existed in the db
            return "Existe GCM";
        }

        return $response;
    }
    /**
     * Funcion para seleccionar todos los gcms de la BAse de datos
     */ 
    public function getGcm() {
        // fetching user by email
        $stmt = $this->conn->prepare("SELECT gcm FROM realTime ");
 
        if ($stmt->execute()) {
        $stmt->bind_result($reg);
            $i=0;
            while($stmt->fetch()){
            //$registros = $stmt->get_result()->fetch_assoc();
                $registros[$i]=$reg;
                ++$i;
            }
            $i=0;
            $stmt->close();
            return $registros;
        }else{
            // user not existed with the email
            return null;
        }
        
     /*   while ($sentencia->fetch()) {
        printf("%s %s\n", $col1, $col2);
      * */
      
    }
    public function getWord($id) {
        // fetching user by email
        $stmt = $this->conn->prepare("SELECT * FROM palabras WHERE id=?");
        
        $stmt->bind_param("s", $id);
        if ($stmt->execute()) {
            // $user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($di,$palabra1,$palabra2,$palabra3,$silaba1,$silaba2,$silaba3,$silaba4);
            $stmt->fetch();
            $user = array();
            $user["palabra1"] = $palabra1;
            $user["palabra2"] = $palabra2;
            $user["palabra3"] = $palabra3;
            $user["silaba1"] = $silaba1;
            $user["silaba2"] = $silaba2;
            $user["silaba3"] = $silaba3;
            $user["silaba4"] = $silaba4;
            


            $stmt->close();
            return $user;
        } else {
            return NULL;
        }
     /*   while ($sentencia->fetch()) {
        printf("%s %s\n", $col1, $col2);
      * */
      
    }
    public function getSecuence($id) {
        // fetching user by email
        $stmt = $this->conn->prepare("SELECT valor FROM simon WHERE id=?");
        
        $stmt->bind_param("s", $id);
        if ($stmt->execute()) {
            // $user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($di);
            $stmt->fetch();
            $user = array();
            
            


            $stmt->close();
            return $di;
        } else {
            return NULL;
        }
     /*   while ($sentencia->fetch()) {
        printf("%s %s\n", $col1, $col2);
      * */
      
    }
    public function getPrototype($id) {
        // fetching user by email
        $stmt = $this->conn->prepare("SELECT pregunta,respuesta,url FROM modulo3 WHERE id=?");
        
        $stmt->bind_param("s", $id);
        if ($stmt->execute()) {
            // $user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($pregunta,$respuesta,$url);
            $stmt->fetch();
            $user = array();
            $user["pregunta"] = $pregunta;
            $user["respuesta"] = $respuesta;
            $user["url"] = $url;

            


            $stmt->close();
            return $user;
        } else {
            return NULL;
        }
     /*   while ($sentencia->fetch()) {
        printf("%s %s\n", $col1, $col2);
      * */
      
    }
    
     public function getUserId($api_key) {
        $stmt = $this->conn->prepare("SELECT id FROM users WHERE api_key = ?");
        $stmt->bind_param("s", $api_key);
        if ($stmt->execute()) {
            $stmt->bind_result($user_id);
            $stmt->fetch();
            // TODO
            // $user_id = $stmt->get_result()->fetch_assoc();
            $stmt->close();
            return $user_id;
        } else {
            return NULL;
        }
    }

     
    /**
     * Checking user login
     * @param String $email User login email id
     * @param String $password User login password
     * @return boolean User login status success/fail
     */
    public function checkLogin($email, $password) {
        // fetching user by email
        $stmt = $this->conn->prepare("SELECT password_hash FROM users WHERE email = ?");

        $stmt->bind_param("s", $email);

        $stmt->execute();

        $stmt->bind_result($password_hash);

        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            // Found user with the email
            // Now verify the password

            $stmt->fetch();

            $stmt->close();

            //if (PassHash::check_password($password_hash, $password)) {
            if (strcmp($password , $password_hash )==0) {
                // User password is correct
                return $email;
            } else {
                // user password is incorrect
                return "fail";
            }
        } else {
            $stmt->close();

            // user not existed with the email
            return "fail";
        }
    }

    /**
     * Checking for duplicate user by email address
     * @param String $email email to check in db
     * @return boolean
     */
    private function isUserExists($email) {
        $stmt = $this->conn->prepare("SELECT id from users WHERE email = ?");
        $stmt->bind_param("s", $email);
        $stmt->execute();
        $stmt->store_result();
        $num_rows = $stmt->num_rows;
        $stmt->close();
        return $num_rows > 0;
    }
    private function ifexistsGCM($Gcm) {
        $stmt = $this->conn->prepare("SELECT id from realTime WHERE gcm = ?");
        $stmt->bind_param("s", $Gcm);
        $stmt->execute();
        $stmt->store_result();
        $num_rows = $stmt->num_rows;
        $stmt->close();
        return $num_rows > 0;
    }

    /**
     * Fetching user by email
     * @param String $email User email id
     */
    public function getUserByEmail($email) {
        $stmt = $this->conn->prepare("SELECT name, email, api_key, status, created_at FROM users WHERE email = ?");
        $stmt->bind_param("s", $email);
        if ($stmt->execute()) {
            // $user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($name, $email, $api_key, $status, $created_at);
            $stmt->fetch();
            $user = array();
            $user["name"] = $name;
            $user["email"] = $email;
            $user["api_key"] = $api_key;
            $user["status"] = $status;
            $user["created_at"] = $created_at;
            $stmt->close();
            return $user;
        } else {
            return NULL;
        }
    }

    /**
     * Fetching user api key
     * @param String $user_id user id primary key in user table
     */
    public function getApiKeyById($user_id) {
        $stmt = $this->conn->prepare("SELECT api_key FROM users WHERE id = ?");
        $stmt->bind_param("i", $user_id);
        if ($stmt->execute()) {
            // $api_key = $stmt->get_result()->fetch_assoc();
            // TODO
            $stmt->bind_result($api_key);
            $stmt->close();
            return $api_key;
        } else {
            return NULL;
        }
    }

    /**
     * Fetching user id by api key
     * @param String $api_key user api key
     */
   

    /**
     * Validating user api key
     * If the api key is there in db, it is a valid key
     * @param String $api_key user api key
     * @return boolean
     */
    public function isValidApiKey($api_key) {
        $stmt = $this->conn->prepare("SELECT id from users WHERE api_key = ?");
        $stmt->bind_param("s", $api_key);
        $stmt->execute();
        $stmt->store_result();
        $num_rows = $stmt->num_rows;
        $stmt->close();
        return $num_rows > 0;
    }
    

    /**
     * Generating random Unique MD5 String for user Api key
     */
    private function generateApiKey() {
        return md5(uniqid(rand(), true));
    }

    /* ------------- `tasks` table method ------------------ */

    /**
     * Creating new task
     * @param String $user_id user id to whom task belongs to
     * @param String $task task text
     */
    public function createTask($user_id, $task) {
        $stmt = $this->conn->prepare("INSERT INTO tasks(task) VALUES(?)");
        $stmt->bind_param("s", $task);
        $result = $stmt->execute();
        $stmt->close();

        if ($result) {
            // task row created
            // now assign the task to user
            $new_task_id = $this->conn->insert_id;
            $res = $this->createUserTask($user_id, $new_task_id);
            if ($res) {
                // task created successfully
                return $new_task_id;
            } else {
                // task failed to create
                return NULL;
            }
        } else {
            // task failed to create
            return NULL;
        }
    }

    /**
     * Fetching single task
     * @param String $task_id id of the task
     */
    public function getTask($task_id, $user_id) {
        $stmt = $this->conn->prepare("SELECT t.id, t.task, t.status, t.created_at from tasks t, user_tasks ut WHERE t.id = ? AND ut.task_id = t.id AND ut.user_id = ?");
        $stmt->bind_param("ii", $task_id, $user_id);
        if ($stmt->execute()) {
            $res = array();
            $stmt->bind_result($id, $task, $status, $created_at);
            // TODO
            // $task = $stmt->get_result()->fetch_assoc();
            $stmt->fetch();
            $res["id"] = $id;
            $res["task"] = $task;
            $res["status"] = $status;
            $res["created_at"] = $created_at;
            $stmt->close();
            return $res;
        } else {
            return NULL;
        }
    }

    /**
     * Fetching all user tasks
     * @param String $user_id id of the user
     */
    public function getAllUserTasks($user_id) {
        $stmt = $this->conn->prepare("SELECT t.* FROM tasks t, user_tasks ut WHERE t.id = ut.task_id AND ut.user_id = ?");
        $stmt->bind_param("i", $user_id);
        $stmt->execute();
        $tasks = $stmt->get_result();
        $stmt->close();
        return $tasks;
    }

    /**
     * Updating task
     * @param String $task_id id of the task
     * @param String $task task text
     * @param String $status task status
     */
    public function updateTask($user_id, $task_id, $task, $status) {
        $stmt = $this->conn->prepare("UPDATE tasks t, user_tasks ut set t.task = ?, t.status = ? WHERE t.id = ? AND t.id = ut.task_id AND ut.user_id = ?");
        $stmt->bind_param("siii", $task, $status, $task_id, $user_id);
        $stmt->execute();
        $num_affected_rows = $stmt->affected_rows;
        $stmt->close();
        return $num_affected_rows > 0;
    }

    /**
     * Deleting a task
     * @param String $task_id id of the task to delete
     */
    public function deleteTask($user_id, $task_id) {
        $stmt = $this->conn->prepare("DELETE t FROM tasks t, user_tasks ut WHERE t.id = ? AND ut.task_id = t.id AND ut.user_id = ?");
        $stmt->bind_param("ii", $task_id, $user_id);
        $stmt->execute();
        $num_affected_rows = $stmt->affected_rows;
        $stmt->close();
        return $num_affected_rows > 0;
    }

    /* ------------- `user_tasks` table method ------------------ */

    /**
     * Function to assign a task to user
     * @param String $user_id id of the user
     * @param String $task_id id of the task
     */
    public function createUserTask($user_id, $task_id) {
        $stmt = $this->conn->prepare("INSERT INTO user_tasks(user_id, task_id) values(?, ?)");
        $stmt->bind_param("ii", $user_id, $task_id);
        $result = $stmt->execute();

        if (false === $result) {
            die('execute() failed: ' . htmlspecialchars($stmt->error));
        }
        $stmt->close();
        return $result;
    }
    public function getUsersRealTime() {
        $stmt = $this->conn->prepare("SELECT id, nombre, gcm, seccion FROM realTime");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $nombre, $gcm, $seccion);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["nombre"] = $nombre;
            $user["gcm"] =$gcm;
            $user["seccion"] = $seccion;
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }
    public function getAllWords() {
        $stmt = $this->conn->prepare("SELECT id, palabra1, palabra2,palabra3 FROM palabras");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $palabra1, $palabra2, $palabra3);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["palabra1"] = $palabra1;
            $user["palabra2"] =$palabra2;
            $user["palabra3"] = $palabra3;
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }
    public function createWord($palabra1, $palabra2, $palabra3,
        $silaba1,$silaba2,$silaba3,$silaba4) {
        $response = array();
        $mijin='INSERT INTO palabras(palabra1,
                                     palabra2,
                                     palabra3,
                                     silaba1,
                                     silaba2,
                                     silaba3,
                                     silaba4
                                     ) values(?,?,?,?,?,?,?)';
        $stmt = $this->conn->prepare($mijin);
        $stmt->bind_param("sssssss", $palabra1,
                                     $palabra2, 
                                     $palabra3,
                                     $silaba1,
                                     $silaba2,
                                     $silaba3,
                                     $silaba4
                );

        $result = $stmt->execute();

        $stmt->close();

        // Check for successful insertion
        if ($result) {
            // User successfully inserted
            return true;
        } else {
            // Failed to create user
            return false;

        }


    return $response;
    }
    public function createPrototype($palabra1, $palabra2, $palabra3) {
        $response = array();
        $mijin='INSERT INTO modulo3(pregunta,
                                    respuesta,
                                    url

                                     ) values(?,?,?)';
        $stmt = $this->conn->prepare($mijin);
        $stmt->bind_param("sss", $palabra1,
                                 $palabra2, 
                                 $palabra3
                );

        $result = $stmt->execute();

        $stmt->close();

        // Check for successful insertion
        if ($result) {
            // User successfully inserted
            return true;
        } else {
            // Failed to create user
            return false;

        }


    return $response;
    }
    public function updateWord($id,$palabra1, $palabra2, $palabra3,
        $silaba1,$silaba2,$silaba3,$silaba4) {
        $stmt = $this->conn->prepare("UPDATE palabras set 
                 palabra1 = ?,
                 palabra2 = ?,
                 palabra3 = ?,
                 silaba1 = ?,
                 silaba2 = ?,
                 silaba3 = ?,
                 silaba4 = ?
                 WHERE id = ?");
        $stmt->bind_param("sssssssi", $palabra1, 
                                      $palabra2,
                                      $palabra3,
                                      $silaba1,
                                      $silaba2,
                                      $silaba3,
                                      $silaba4,
                                      $id  );
        $stmt->execute();
        $num_affected_rows = $stmt->affected_rows;
        $stmt->close();
        return $num_affected_rows > 0;
    }
    public function getAllWordsMobile() {
        $stmt = $this->conn->prepare("SELECT id, palabra1, palabra2,palabra3,silaba1,silaba2,silaba3,silaba4 FROM palabras");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $palabra1, $palabra2, $palabra3,$silaba1,$silaba2,$silaba3,$silaba4);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["palabra1"] = $palabra1;
            $user["palabra2"] =$palabra2;
            $user["palabra3"] = $palabra3;
            $user["silaba1"] = $silaba1;
            $user["silaba2"] = $silaba2;
            $user["silaba3"] = $silaba3;
            $user["silaba4"] = $silaba4;
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }
    public function getAllSecuencesMobile() {
        $stmt = $this->conn->prepare("SELECT id, valor FROM simon");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $valor);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["valor"] = $valor;
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }    
    public function createSecuence($palabra1) {
        $response = array();
        $mijin='INSERT INTO simon(valor) values(?)';
        $stmt = $this->conn->prepare($mijin);
        $stmt->bind_param("s", $palabra1);

        $result = $stmt->execute();

        $stmt->close();

        // Check for successful insertion
        if ($result) {
            // User successfully inserted
            return true;
        } else {
            // Failed to create user
            return false;

        }


    return $response;
    }
    public function getAllSecuences() {
        $stmt = $this->conn->prepare("SELECT id, valor FROM simon");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $palabra1);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["palabra1"] = $palabra1;
           
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }
    public function getAllPrototipos() {
        $stmt = $this->conn->prepare("SELECT id, pregunta,respuesta,url FROM modulo3");
        //$stmt->bind_param("s", $email);
        
        if ($stmt->execute()) {
            //$user = $stmt->get_result()->fetch_assoc();
            $stmt->bind_result($id, $pregunta,$respuesta,$url);
            
            while ($stmt->fetch()) {
            
            //$stmt->fetch();
            $user = array();
            $user["id"] = $id;
            $user["pregunta"] = $pregunta;
            $user["respuesta"] = $respuesta;
            $user["url"] = $url;
           
            $arrap[]=$user;
            }
            $stmt->close();
            return $arrap;
        } else {
            return NULL;
        
    }
    }    

}

?>
