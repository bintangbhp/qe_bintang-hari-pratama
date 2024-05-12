//Method GET: Mendapatkan Semua Data Post

//Mendapatkan semua data post dengan status code 200
pm.test('response status code should have 200 value', () =>{
    pm.response.to.have.status(200);
  });
  
  //Respons memiliki minimal satu data post
  pm.test('response should contain posts data', () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson).to.be.an('array').that.is.not.empty;
  });
  
  //Setiap data post memiliki atribut id dan title
  pm.test('each post should have id and title attributes', () => {
    const responseJson = pm.response.json();
    const posts = responseJson;
  
    posts.forEach(post => {
        pm.expect(post).to.have.property('id');
        pm.expect(post).to.have.property('title');
    });
  });
  
  //Respons berisi data kosong (null value)
  pm.test('response should be empty', () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson).to.be.an('array').that.is.empty;
  });
  
  //Memastikan respons berformat salah
  pm.test('response should be in PDF format', () => {
    const contentType = pm.response.headers.get('Content-Type');
  
    //misal pdf
    pm.expect(contentType).to.include('application/pdf'); 
    pm.expect(pm.response.text()).to.include('%PDF-'); 
  });
    
  // Method POST: Membuat data post baru
  
  //Membuat data post baru dengan status code 201
  pm.test('creating a new post should be successful', () => {
    const responseBody = pm.response.json();
    pm.expect(pm.response.code).to.equal(201); 
  });
  
  //Memeriksa post baru memiliki atribut valid
  pm.test('response should contain expected properties', () => {
    const responseBody = pm.response.json();
    pm.expect(responseBody).to.have.all.keys('id', 'title', 'body', 'userId'); // Memastikan respons memiliki properti yang diharapkan
  });
  
  //Memastikan bahwa memiliki response 400 (Bad Request) atau 422 (Unprocessable Entity)
  pm.test('incomplete request body should fail', () => {
    pm.expect(pm.response.code).to.be.oneOf([400, 422]);
  });
  
  //Mengirim dengan parameter tambahan yang tidak dikenali
  pm.test('unrecognized parameters should fail', () => {
    const requestBody = {
        "title": "foo",
        "body": "bar",
        "userId": 1,
        "extraParameter": "value" 
    };
    
    pm.expect(pm.response.code).to.be.oneOf([400, 422]); 
  });
  
  //Memeriksa atribut "id" tidak ada dalam respon
  pm.test('response should not have "id" attribute', () => {
    const responseBody = pm.response.json();
  
    // Memeriksa apakah atribut "id" tidak ada dalam respons
    pm.expect(responseBody).to.not.have.property('id');
  });
    
  //Method GET: Mengubah data post berdasarkan ID
  
  //Memastikan respons berhasil
  pm.test('Get Post by ID - Successful', () => {
    pm.response.to.have.status(200);
  });
  
  //Respons mengandung data post dengan ID valid
  pm.test('Get Post by ID - Successful', () => {
    pm.response.to.have.status(200);
  });
  
  //Respons end-point adalah 404
  pm.test('Get Post by ID - Successful', () => {
    pm.response.to.have.status(200);
  });
  
  //Respons mengandung data yang sesuai dengan aslinya
  pm.test('Check Response Data', () => {
    const expectedData = {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    };
  
    const responseData = pm.response.json();
    
    pm.expect(responseData).to.eql(expectedData);
  });
  
  //Mengecek respons dengan data yang unvalid
  pm.test('Check Response Data', () => {
    const expectedData = {
        "userId": 100,
        "id": 100,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    };
  
    const responseData = pm.response.json();
    
    pm.expect(responseData).to.eql(expectedData);
  });
    
  //Method PUT: Mengubah data post berdasarkan ID
  
  //Memastikan update data post berdasarkan ID berhasil
  pm.test('Update Post - Successful', () => {
    pm.response.to.have.status(200);
  });
  
  //Memastikan update data post berhasil sesuai data valid
  pm.test('Check Updated Post Data', () => {
    const updatedData = {
        "id": 1,
        "title": "foo",
        "body": "bar",
        "userId": 1
    };
  
    const responseData = pm.response.json();
    
    pm.expect(responseData).to.eql(updatedData);
  });
  
  //Update data post dengan ID unvalid
  pm.test('Check Updated Post Data', () => {
    const updatedData = {
        "id": 999,
        "title": "foo",
        "body": "bar",
        "userId": 1
    };
  
    const responseData = pm.response.json();
    
    pm.expect(responseData).to.eql(updatedData);
  });
  
  //Memastikan update data post gagal dengan status 400
  pm.test('Update Post with Invalid Data - Bad Request', () => {
    pm.response.to.have.status(400);
  });
  
  //Update data post berhasil tanpa parameter ID dan userID 
  pm.test('Check Updated Post Data', () => {
    const updatedData = {
        "title": "foo",
        "body": "bar",
    };
  
    const responseData = pm.response.json();
    
    pm.expect(responseData).to.eql(updatedData);
  });
    
  //Method GET: Delete data post from ID
  
  //Delete data post berdasarkan ID 
  pm.test('Delete Post by ID - Success', () => {
    pm.response.to.have.status(200);
  });
  
  //Memastikan data post yang dihapus tidak tersedia lagi
  pm.test('Check Deleted Post Availability', () => {
    pm.response.to.have.status(404); 
  });
  
  //Memastikan response 500 (internal server error)
  pm.test('Delete Post by ID - Success', () => {
    pm.response.to.have.status(500);
  });