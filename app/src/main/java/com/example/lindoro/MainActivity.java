package com.example.lindoro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtPalabra;
    Button btnBuscar;
    Button btnGetPost;
    Button btnGetComments;
    Button btnCreatePost;
    Button btnUpdatePost;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPalabra = findViewById(R.id.edtPalabra);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(this);
        btnGetPost = findViewById(R.id.btnGetPost);
        btnGetPost.setOnClickListener(this);
        btnGetComments = findViewById(R.id.btnGetComments);
        btnGetComments.setOnClickListener(this);
        btnCreatePost = findViewById(R.id.btnCreatePost);
        btnCreatePost.setOnClickListener(this);
        btnUpdatePost = findViewById(R.id.btnUpdatePost);
        btnUpdatePost.setOnClickListener(this);
        txtResultado = findViewById(R.id.txtResultado);
    }

    private void resultado(String q) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // serializacion
                .build();

        PostService postService = retrofit.create(PostService.class); //interface PostService
        Call<List<Post>> call = postService.find(q);
        call.enqueue(new Callback<List<Post>>(){

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postsList = response.body();
                for (Post p: postsList){
                    String resultado = "";
                    resultado+= "UserID: " + p.getUserId() + "\n";
                    resultado+= "ID: " + p.getId() + "\n";
                    resultado+= "Title: " + p.getTitle() + "\n";
                    resultado+= "Body: " + p.getBody() + "\n";
                    txtResultado.append(resultado);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });

    }

    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // serializacion
                .build();

        UserService postService = retrofit.create(UserService.class); //interface PostService
        Call<List<User>> call = postService.findUsersByEmail("Sincere@april.biz");
        call.enqueue(new Callback<List<User>>(){

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> postsList = response.body();
                for (User p: postsList){
                    String resultado = "";
                    resultado+= "ID: " + p.getId() + "\n";
                    resultado+= "Username: " + p.getUsername() + "\n";
                    resultado+= "Phone: " + p.getPhone() + "\n";
                    resultado+= "Address Street: " + p.getAddress().getStreet() + "\n";
                    resultado+= "Address Suite: " + p.getAddress().getSuite() + "\n";
                    resultado+= "Address City: " + p.getAddress().getCity() + "\n";
                    resultado+= "Address ZipCode: " + p.getAddress().getZipcode() + "\n";
                    resultado+= "Company Name: " + p.getCompany().getName() + "\n";
                    resultado+= "Company catchPhrase: " + p.getCompany().getCatchPhrase() + "\n";
                    resultado+= "Company bs: " + p.getCompany().getBs() + "\n\n";

                    txtResultado.append(resultado);

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });
    }


//    private void getPosts(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create()) // serializacion
//                .build();
//
//        PostService postService = retrofit.create(PostService.class); //interface PostService
//        Call<List<Post>> call = postService.getPost();
//        call.enqueue(new Callback<List<Post>>(){
//
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                List<Post> postsList = response.body();
//                for (Post p: postsList){
//                    String resultado = "";
//                    resultado+= "UserID: " + p.getUserId() + "\n";
//                    resultado+= "ID: " + p.getId() + "\n";
//                    resultado+= "Title: " + p.getTitle() + "\n";
//                    resultado+= "Body: " + p.getBody() + "\n";
//                    txtResultado.append(resultado);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                txtResultado.setText(t.getMessage());
//            }
//        });
//    }

    private void getComments(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // serializacion
                .build();

        PostService postService = retrofit.create(PostService.class); //interface PostService
        Call<List<Comment>> call = postService.getComments("posts/4/comments");
        call.enqueue(new Callback<List<Comment>>(){

            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                List<Comment> commentsList = response.body();
                for (Comment p: commentsList){
                    String resultado = "";
                    resultado+= "UserID: " + p.getId() + "\n";
                    resultado+= "ID: " + p.getPostId() + "\n";
                    resultado+= "Title: " + p.getName() + "\n";
                    resultado+= "Email: " + p.getEmail() + "\n";
                    resultado+= "Text: " + p.getText() + "\n";

                    txtResultado.append(resultado);

                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });
    }

    private void createPost(){

        Post post = new Post(23, "Nuevo Titulo", "Nuevo Texto");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // serializacion
                .build();

        PostService postService = retrofit.create(PostService.class); //interface PostService
        //Call<Post> call = postService.createPost(post);
        Call<Post> call = postService.createPost(23, "Soy yo", "Somos Todos");
        call.enqueue(new Callback<Post>(){
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()){
                    txtResultado.setText("code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String resultado = "";

                resultado+= "Code: " + response.code() + "\n";
                resultado+= "ID: " + postResponse.getId() + "\n";
                resultado+= "UserID: " + postResponse.getUserId() + "\n";
                resultado+= "Title: " + postResponse.getTitle() + "\n";
                resultado+= "Text: " + postResponse.getBody() + "\n\n";

                txtResultado.append(resultado);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });
    }

    private void updatePost(){

        Post post = new Post(23, "Nuevo Titulo", "Nuevo Texto");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // serializacion
                .build();

        PostService postService = retrofit.create(PostService.class); //interface PostService
        //Call<Post> call = postService.createPost(post);
        Call<Post> call = postService.putPost(23, post);
        call.enqueue(new Callback<Post>(){
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()){
                    txtResultado.setText("code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String resultado = "";

                resultado+= "Code: " + response.code() + "\n";
                resultado+= "ID: " + postResponse.getId() + "\n";
                resultado+= "UserID: " + postResponse.getUserId() + "\n";
                resultado+= "Title: " + postResponse.getTitle() + "\n";
                resultado+= "Text: " + postResponse.getBody() + "\n\n";

                txtResultado.append(resultado);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        switch (b.getId()){
            case R.id.btnBuscar:
                txtResultado.setText("");
                resultado(edtPalabra.getText().toString());
                break;
            case R.id.btnGetPost:
                txtResultado.setText("");
                getPosts();
                break;
            case R.id.btnGetComments:
                txtResultado.setText("");
                getComments();
                break;
            case R.id.btnCreatePost:
                txtResultado.setText("");
                createPost();
                break;
            case R.id.btnUpdatePost:
                txtResultado.setText("");
                updatePost();
                break;
        }
    }
}