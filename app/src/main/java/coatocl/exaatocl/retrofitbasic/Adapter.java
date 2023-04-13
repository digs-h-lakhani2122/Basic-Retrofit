package coatocl.exaatocl.retrofitbasic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private Context context;
    private List<CustomModel> userListResponseData;

    Adapter(Context context, List<CustomModel> userListResponseData) {
        this.context = context;
        this.userListResponseData = userListResponseData;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.show,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position)
    {
        CustomModel customModel = userListResponseData.get(position);

        holder.name.setText("NAME :"+ customModel.getName());
        holder.email.setText("EMAIL :"+customModel.getEmail());
        holder.password.setText("MOBILE :"+customModel.getPassword());

    }

    @Override
    public int getItemCount() {
        return userListResponseData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,email,password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.t1);
            email = itemView.findViewById(R.id.t2);
            password = itemView.findViewById(R.id.t3);

        }
    }
}
