package io.github.vinge1718.restaurant.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter adapter){
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled(){
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled(){
        return true;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder){
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder source,@NonNull RecyclerView.ViewHolder target){
        if(source.getItemViewType() != target.getItemViewType()){
            return false;
        }
        mAdapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i){
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState){
        //  This conditional ensures we only change appearance of active items:
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            if (viewHolder instanceof ItemTouchHelperViewHolder){
                //  This tells the viewHolder that an item is being moved or dragged:
                ItemTouchHelperViewHolder itemViewHolder = (ItemTouchHelperViewHolder) viewHolder;
                itemViewHolder.onItemSelected();
            }
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder){
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof ItemTouchHelperViewHolder){
            //  Tells the view holder to return the item back to its normal appearance:
            ItemTouchHelperViewHolder itemViewHolder = (ItemTouchHelperViewHolder) viewHolder;
            itemViewHolder.onItemClear();
        }
    }
}
