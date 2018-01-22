package eu.vanyamihova.starter.presentation.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Parent of all RecyclerView.Adapter
 * Created by  Vanya Mihova on 28.01.17.
 */
public abstract class BaseRecyclerViewAdapter<DO, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    public List<DO> mObjects;
    protected Context mContext;
    protected BaseFragment mFragment;

    public BaseRecyclerViewAdapter(List<DO> objects) {
        this.mObjects = objects;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater
                .from(mContext)
                .inflate(layoutId(), parent, false);

        return onCreateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindViewHolder(holder, getItem(position));
    }

    public void setFragment(BaseFragment fragment) {
        this.mFragment = fragment;
    }

    public abstract int layoutId();
    public abstract VH onCreateViewHolder(View view);
    public abstract void onBindViewHolder(VH holder, DO item);

    public void setNewList(List<DO> object) {
        mObjects = object;
        notifyDataSetChanged();
    }


    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void addLast(final DO object) {
        mObjects.add(object);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        final int size = getItemCount();
        mObjects.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public int getItemCount() {
        return (mObjects != null) ? mObjects.size() : 0;
    }

    /**
     * Return all items of the type
     * @return
     */
    public List<DO> getItems() {
        return (this.mObjects == null) ? new ArrayList<DO>() : this.mObjects;
    }

    public DO getItem(final int position) {
        return mObjects.get(position);
    }

    public long getItemId(final int position) {
        return position;
    }

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    public int getPosition(final DO item) {
        return mObjects.indexOf(item);
    }

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index  The index at which the object must be inserted.
     */
    public void insert(final DO object, int index) {
        mObjects.add(index, object);
        notifyItemInserted(index);

    }

    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    public void remove(DO object) {
        final int position = getPosition(object);
        mObjects.remove(object);
        notifyItemRemoved(position);
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained in this adapter.
     */
    public void sort(Comparator<? super DO> comparator) {
        Collections.sort(mObjects, comparator);
        notifyItemRangeChanged(0, getItemCount());
    }

}
