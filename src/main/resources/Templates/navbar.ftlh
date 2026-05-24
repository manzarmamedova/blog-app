<div class="navbar">
    <a href="/">Home</a>
    <a href="/admin/create">New Post</a>
</div>
<nav>

    <a href="/">Home</a>
    <a href="/about">About</a>

    <#if user??>

        <a href="/posts/new">New Post</a>
        <a href="/logout">Logout</a>

    <#else>

        <a href="/login">Login</a>
        <a href="/register">Register</a>

    </#if>

</nav>