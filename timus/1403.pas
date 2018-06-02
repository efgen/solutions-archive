var a,p,d,ind:array[1..1100] of integer;
i,j,k,n,min,q:integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  Read(n);
  for i:=1 to n do Read(d[i],p[i]);
  for i:=1 to n do ind[i]:=i;
  for i:=1 to n do
  begin
    min:=i;
    for j:=i+1 to n do
      if d[j]<d[min]  then min:=j;
    q:=ind[i]; ind[i]:=ind[min]; ind[min]:=q;
    q:=p[i]; p[i]:=p[min]; p[min]:=q;
    q:=d[i]; d[i]:=d[min]; d[min]:=q;
  end;
  k:=0;
  for i:=1 to n do
  begin
    if d[i]>k then
    begin
      inc(k);
      a[k]:=i;
    end else
    begin
      min:=1; j:=1;
      while d[a[j]]<=d[i] do
      begin
        if p[a[j]]<p[a[min]] then
          min:=j;
        inc(j);
        if j>k then break;
      end;
      if p[a[min]]<p[i] then a[min]:=i;
    end;
  end;
  Writeln(k);
  for i:=1 to k do Write(ind[a[i]],' ');
 // Close(input);Close(output);
end.
