<#assign basePath=request.contextPath />
<link href="${basePath}/codemirror/lib/codemirror.css" rel="stylesheet">
<link href="${basePath}/codemirror/theme/idea.css" rel="stylesheet">
<link href="${basePath}/css/editor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${basePath}/codemirror/lib/codemirror.js"></script>
<script type="text/javascript" charset="utf-8" src="${basePath}/codemirror/mode/markdown/markdown.js"></script>
<script type="text/javascript" charset="utf-8" src="${basePath}/codemirror/keymap/sublime.js"></script>
<script type="text/javascript" charset="utf-8" src="${basePath}/marked/marked.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${basePath}/js/app.markdown.js"></script>
<div class="md-editor">
    <div class="editor-toolbar">
        <button type="button" event="undo" title="撤销">
            <i class="icon fa fa-rotate-left"></i>
        </button>
        <button type="button" event="redo" title="上一步">
            <i class="icon fa fa-rotate-right"></i>
        </button>
        <i class="separator">|</i>
        <button type="button" event="bold" title="字体加粗">
            <i class="icon fa fa-bold"></i>
        </button>
        <button type="button" event="italic" title="字体倾斜">
            <i class="icon fa fa-italic"></i>
        </button>
        <button type="button" event="h2" title="标题">
            <i class="icon fa fa-h-square"></i>
        </button>
        <button type="button" event="blockquote" title="引用">
            <i class="icon fa fa-quote-left"></i>
        </button>
        <button type="button" event="link" title="链接">
            <i class="icon fa fa-link"></i>
        </button>
        <button type="button" event="image" title="图片引用">
            <i class="icon fa fa-image"></i>
        </button>
        <button type="button" event="uploadimage" title="本地上传图片">
            <i class="icon fa fa-photo"></i>
        </button>
        <button type="button" event="inlinecode"title="代码块">
            <i class="icon fa fa-code"></i>
        </button>
        <i class="separator">|</i>
        <button type="button" class="active" event="premode" data-value="editMode" title="单页编辑模式">
            <i class="icon fa fa-tablet"></i>
        </button>
        <button type="button" event="premode" data-value="liveMode" title="双屏编辑模式片">
            <i class="icon fa fa-columns"></i>
        </button>
        <button type="button" event="premode" data-value="previewMode" title="预览模式">
            <i class="icon fa fa-desktop"></i>
        </button>
        <i class="separator">|</i>
        <button type="button" event="fullscreen" title="全屏">
            <i class="icon fa fa-arrows-alt"></i>
        </button>
    </div>
    <div class="editor-container editMode">
        <div class="editor-body">
            <textarea id="content" name="content" rows="5" class="form-control" required>${articleVo.article.content?html}</textarea>
        </div>
        <div class="editor-preview markdown-body">
        </div>
    </div>
</div>
