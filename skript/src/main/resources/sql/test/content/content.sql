INSERT INTO content_type (id, name, value) VALUES
                                               (1, 'مقاله', 'article'),
                                               (2, 'سوال', 'question'),
                                               (3, 'کالا','product');


INSERT INTO _content (
    id, body, code, date, language, description,
    title, slug, seq, content_type_id, target_type, target_id
) VALUES
    (1001, '<p>متن تستی برای بدنه محتوا</p>', 'CODE-123', now(), 'fa', 'توضیح تستی',
     'عنوان تستی', 'test-content-slug', 0, 1, 'PRODUCT', 501);



INSERT INTO content_category (id, content_id, category_id)
VALUES
    (3001, 1001, 10);


INSERT INTO tag (id, name)
VALUES
    (4001, 'جدید'), (4002, 'ویژه');

INSERT INTO content_tag (content_id, tag_id)
VALUES
    (1001, 4001), (1001, 4002);

INSERT INTO _content (id, body, slug, title)
VALUES (1002, 'محتوای مرتبط', 'related-content', 'مرتبط');

INSERT INTO content_related_content (id, related_content_id)
VALUES (1001, 1002);


INSERT INTO PAGE (id, ARTICLE_ID, PAGE_NUMBER, TITLE, BODY, LANGUAGE, SLUG, CONTENT_ID, COMMENT_TARGET_ID)
VALUES (1, null, 1, 'صفحه محصول نمونه', '<p>این محتوای نمونه برای محصول با شناسه 1 است.</p>', 'fa', 'sample-product-page', 1, null);

INSERT INTO _CONTENT (
    id, -- اگر بانک اتوماتیک نیست، مقدار مناسبی بگذارید یا حذف کنید
    CODE,
    DATE,
    LANGUAGE,
    DESCRIPTION,
    TITLE,
    SLUG,
    BODY,
    TARGET_TYPE,
    TARGET_ID,
    CONTENT_TYPE_ID,
    SEQ
) VALUES (
             1003,
             'product-description-1',
             NOW(),
             'fa',
             'توضیحات کامل محصول شماره 1',
             'توضیحات محصول نمونه',
             'product-sample-content',
             '<p>متن کامل و HTML توضیحات محصول نمونه برای تست</p>',
             'PRODUCT',
             1,
             null,
             0
         );

