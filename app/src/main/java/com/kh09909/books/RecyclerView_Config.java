package com.kh09909.books;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private BookAdapter mBookAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Book> books, List<String> keys){
        mContext = context;
        mBookAdapter = new BookAdapter(books, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBookAdapter);
    }

    class BookItemView extends RecyclerView.ViewHolder {

        private TextView mTitle, mAuther, mISBN, mCategory;

        private String key;

        public BookItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext)
                    .inflate(R.layout.book_list_item, parent, false));

            mTitle = (TextView) itemView.findViewById(R.id.title_textView);
            mAuther = (TextView) itemView.findViewById(R.id.auther_textView);
            mCategory = (TextView) itemView.findViewById(R.id.category_textView);
            mISBN = (TextView) itemView.findViewById(R.id.isbn_textView);
        }

        public void bind(Book book, String key){
            mTitle.setText(book.getTitle());
            mAuther.setText(book.getAuther());
            mCategory.setText(book.getCategory_name());
            mISBN.setText(book.getIsbn());
            this.key = key;
        }
    }

    class BookAdapter extends RecyclerView.Adapter<BookItemView>{

        private List<Book> mBookList;
        private List<String> mKeys;

        public BookAdapter(List<Book> mBookList, List<String> mKeys) {
            this.mBookList = mBookList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BookItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BookItemView holder, int position) {
            holder.bind(mBookList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }

}
