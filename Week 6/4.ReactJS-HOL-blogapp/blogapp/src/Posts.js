import React from "react";
import Post from "./Post";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch("https://jsonplaceholder.typicode.com/posts");
      const data = await response.json();
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
      const posts = data.map(post => new Post(post.id, post.title, post.body));

      this.setState({ posts });
    } catch (error) {
      this.setState({ hasError: true });
      alert("Failed to load posts: " + error.message);
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error.toString());
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1 style={{ textAlign: "center", color: "red" }}>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: "1px solid #ccc", marginBottom: "15px" }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
