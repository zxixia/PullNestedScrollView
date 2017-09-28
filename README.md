## PullNestedScrollView

- **A support nested scroll pull down view**.
- By touch anywhere to **pull down** or **pull up**, you can increase or decrease the visible area of the header picture.
- It support **nested scroll**, both horizontal and vertical RecyclerView inside it works fine.

## Preview

The demo is a static movie page with a big post in the top area. Touch anywhere to pull down or pull up the page.

![default](https://github.com/zxixia/PullNestedScrollView/blob/master/_assets/default.gif?raw=true)

## Nested scroll

For the horizontal RecyclerView.

![vertical](https://raw.githubusercontent.com/zxixia/PullNestedScrollView/master/_assets/horizontal.gif)

For the vertical RecyclerView.

![vertical](https://github.com/zxixia/PullNestedScrollView/blob/master/_assets/vertical.gif?raw=true)

## How to use

Follow this two steps to add this view your work:

- 1, modify the top image.
- 2, modify your own layout.

To add your top image, just change the drawable in the **`activity_main.xml`**.
```html
    <ImageView
        android:id="@+id/iv_header_image"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:layout_marginTop="-100dp"
        android:layout_alignParentTop="true"
        android:src="@drawable/the_myth"
        android:scaleType="centerCrop"/>
```

Then keep the **`activity_main.xml`**, only modify the **`sub_page.xml`** to reach your need.