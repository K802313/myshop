##根据用户id 获取角色
select r.* from shop_user_login u inner join user_role ur on u.ID =ur.uid
inner join role r on ur.rid =r.id where u.ID='1';

## 根据角色id 获取权限

explain select p.* from role r inner join role_permission rp on r.id=rp.rid
inner join permission p on p.id=rp.pid where r.id ='2';

## 根据用户名获取权限
explain select r.* from shop_user_login u
    inner join user_role ur on  u.ID=ur.uid
    inner join role r on r.id=ur.rid
    inner join role_permission rp on r.id=rp.rid
    inner join permission p on p.id=rp.pid
    where u.ID='2'
    
    