<#include "layout.ftlh">

<@layout title="<#if post.id??>Edit Post<#else>New Post</#if>">

    <div class="create-page">
        <div class="create-header">
            <a href="/" class="back-link">← Back to Posts</a>
            <h1><#if post.id??>Edit Post<#else>Write a New Post</#if></h1>
            <p class="create-sub">Share your knowledge with the world.</p>
        </div>

        <div class="create-layout">
            <div class="create-form-card">

                <!-- ERROR MESSAGE -->
                <#if errors??>
                    <div class="error-box">
                        <#list errors as e>
                            <p>${e.defaultMessage}</p>
                        </#list>
                    </div>
                </#if>

                <#if errorMessage??>
                    <div class="error-box">
                        <p>${errorMessage}</p>
                    </div>
                </#if>


                <form action="<#if post.id??>/admin/update/${post.id}<#else>/admin/create</#if>"
                      method="post"
                      enctype="multipart/form-data">

                    <!-- TITLE -->
                    <div class="form-group">
                        <label class="form-label">Title</label>
                        <input class="form-input"
                               name="title"
                               placeholder="Enter your post title..."
                               value="${post.title!}"
                               required>
                    </div>

                    <!-- CONTENT -->
                    <div class="form-group">
                        <label class="form-label">Content</label>
                        <textarea class="form-input form-textarea"
                                  name="content"
                                  rows="16"
                                  placeholder="Write your post content here..."
                                  required>${post.content!}</textarea>
                    </div>

                    <!-- FILE UPLOAD -->
                    <div class="form-group">
                        <label class="form-label">Upload Image</label>
                        <input type="file" name="file" class="form-input">
                    </div>

                    <!-- IMAGE PREVIEW -->
                    <#if post.imagePath??>
                        <div class="form-group">
                            <p>Current Image:</p>
                            <img src="${post.imagePath}" style="max-width:200px;">
                        </div>
                    </#if>

                    <div class="form-actions">
                        <button type="submit" class="btn-primary large">
                            <#if post.id??>Save Changes<#else>Publish Post</#if>
                        </button>
                        <a href="/" class="btn-outline large">Cancel</a>
                    </div>

                </form>

            </div>

            <div class="create-tips">
                <div class="sidebar-card">
                    <h4 class="sidebar-title">Writing Tips</h4>
                    <ul class="tips-list">
                        <li>Keep your title clear and descriptive</li>
                        <li>Start with a brief introduction</li>
                        <li>Use examples to explain concepts</li>
                        <li>Keep paragraphs short and readable</li>
                    </ul>
                </div>
                <div class="sidebar-card">
                    <h4 class="sidebar-title">Status</h4>
                    <div class="status-item">
                        <span class="status-dot active"></span>
                        <span>Ready to publish</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

</@layout>
